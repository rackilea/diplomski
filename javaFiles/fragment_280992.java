@GetMapping("/pgTabelka")
public Map<String, Object> pgTable(HttpServletRequest request)
{
    Map<String, Object> json = new HashMap();

    int draw = 0;
    int start = 0;
    int length = 10;

    if(request.getParameter("draw")!=null)
        draw = Integer.parseInt(request.getParameter("draw"));
    if(request.getParameter("start")!=null)
        start = Integer.parseInt(request.getParameter("start"));
    if(request.getParameter("length")!=null)
        length = Integer.parseInt(request.getParameter("length"));
    int totalRecords = sed.recordsTotal();

    List<Seria> serie = sed.findPart(start, length);

    json.put("draw", ++draw);
    json.put("recordsTotal", totalRecords);
    json.put("recordsFiltered", totalRecords);
    json.put("data", serie);

    return json;
}