@RequestMapping(path = "/ApplicationName/Data/Person", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public TableBean getPersonData(@RequestParam Map<String, String> allRequestParams) {

    TableParameters tableParameters = myMapperService
            .getTableParameters(allRequestParams);

    return myMapperService.mapTableBean(tableParameters); //returns an TableBean which contains the ArrayList<Person>
}