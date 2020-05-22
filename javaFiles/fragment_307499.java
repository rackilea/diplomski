@Override
@RequestMapping(value = "/clientes")
@ResponseBody
public DatatablesResponse<MyObject> data(HttpServletRequest request){
    List<MyObject> myObjectList = ... //logic to fetch a list of objects

    DatatablesCriterias criterias = DatatablesCriterias.getFromRequest(request);
    DataSet<MyObject> dataSet = new DataSet<>(myObjectList, (long)myObjectList.size(), (long)myObjectList.size());
    return DatatablesResponse.build(dataSet, criterias);
}