@Autowired
private ContentQueryValidator validator;

@RequestMapping("/query")
@ResponseBody
public ResponseEntity<List<Content>> getByQuery(
        HttpServletRequest request, ContentQuery query, BindingResult result) {
    validator.validate(query, result);
    if(result.hasErrors()){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // No errors. Fetch content from service using query object.
}