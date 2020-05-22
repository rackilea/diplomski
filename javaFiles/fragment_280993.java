@GetMapping("/pgTabelka")
public YourJsonDataClass pgTable(HttpServletRequest request)
{
    ...

    YourJsonDataClass json = new YourJsonDataClass();
    json.setDraw(++draw);
    json.setRecordsTotal(totalRecords);
    json.setRecordsFiltered(totalRecords);
    json.setData(serie);

    return json;
}