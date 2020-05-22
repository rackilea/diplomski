@RestController
public class SearchController {

@Autowired
private SearchDelegate searchDelegate;

@GetMapping(value = "/{customerId}/search")
@ResponseStatus(HttpStatus.OK)
@ApiOperation(value = "Search Sources", notes = "Search Sources")
@ApiResponses(value = {
        @ApiResponse(code = 201, message = "OK"),
        @ApiResponse(code = 401, message = "Unauthorized")
})
@ResponseBody
public SseEmitter search(@ApiParam(name = "searchCriteria", value = "searchCriteria", required = true) @ModelAttribute @Valid final SearchCriteriaDto searchCriteriaDto) throws Exception {
    return searchDelegate.route(searchCriteriaDto);
  }
}



@Service
public class SearchDelegate {
public static final String SEARCH_EVENT_NAME = "SEARCH";
public static final String COMPLETE_EVENT_NAME = "COMPLETE";
public static final String COMPLETE_EVENT_DATA = "{\"name\": \"COMPLETED_STREAM\"}";

@Autowired
private SearchService searchService;

private ExecutorService executor = Executors.newCachedThreadPool();

public SseEmitter route(SearchCriteriaDto searchCriteriaDto) throws Exception {
    SseEmitter emitter = new SseEmitter();
    executor.execute(() -> {
        try {
            if(!searchCriteriaDto.getCustomerSources().isEmpty()) {
                searchCriteriaDto.getCustomerSources().forEach(customerSource -> {
                    try {
                        SearchResponse searchResponse = searchService.search(searchCriteriaDto);
                        emitter.send(SseEmitter.event()
                                .id(customerSource.getSourceId())
                                .name(SEARCH_EVENT_NAME)
                                .data(searchResponse));
                    } catch (Exception e) {
                        log.error("Error while executing query for customer {} with source {}, Caused by {}",
                                customerId, source.getType(), e.getMessage());
                    }
                });
            }else {
                log.debug("No available customerSources for the specified customer");
            }
            emitter.send(SseEmitter.event().
                    id(String.valueOf(System.currentTimeMillis()))
                    .name(COMPLETE_EVENT_NAME)
                    .data(COMPLETE_EVENT_DATA));
            emitter.complete();
        } catch (Exception ex) {
            emitter.completeWithError(ex);
        }
    });
    return emitter;
   }
}