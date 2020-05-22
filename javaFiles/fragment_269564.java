@RequestMapping(path="/timesheets",method=RequestMethod.GET)
public List<Timesheet> getTimesheets() {

    List<Timesheet> results = new ArrayList<>();
    timeRepo.findAll().forEach(results::add);

    return results;
}