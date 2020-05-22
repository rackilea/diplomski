@RestController
public class CusttableController {

    @RequestMapping(value="/custtable", method=RequestMethod.POST)
    public List<MyObject> getCusttableRecords(@RequestBody List<Custtable> customers) {...}
}