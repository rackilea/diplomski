public class WeeklyBoxOfficeService {

    @Autoware
    private WeeklyBoxOfficeRepo repo;

    public WeeklyBoxOffice saveWithoutMovie(WeeklyBoxOffice weeklyBoxOffice) {

        weeklyBoxOffice.setMovie(null); // 'unlink' movie from BO
        repo.save(weeklyBoxOffice); // save BO without movie
    }  
}

@RestController
@RequestMapping("/weeklyBoxOffice")
public class WeeklyBoxOfficeController {

    @Autoware
    private WeeklyBoxOfficeService service;

    @PostMapping
    public ResponseEntity<?> saveWithoutMovie(@RequestBody WeeklyBoxOffice weeklyBoxOffice) {

        WeeklyBoxOffice result = service.saveWithoutMovie(weeklyBoxOffice);
        return ResponseEntity.ok(result);
    }
}