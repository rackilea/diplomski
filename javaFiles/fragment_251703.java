@RestController
@RequestMapping("api") 
@CrossOrigin({ "*", "http://localhost:4200" })
public class HouseController {

   private   HouseService houseServ;

    public HouseController(HouseService houseServ) {
        this.houseServ = houseServ;
    }

    @GetMapping(value = "index/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public House show(@PathVariable("id") Integer id) {
        return houseServ.show(id); 
    }
}