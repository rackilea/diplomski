@Controller
public class MyController {

    @RequestMapping(value="/myexcel", method=RequestMethod.GET)
    public ModelAndView getMyData(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        Map<String, Object> model = new HashMap<String, Object>();
        //Sheet Name
        model.put("sheetname", "TestSheetName");
        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Column1");
        headers.add("Column2");
        headers.add("Column3");
        model.put("headers", headers);
        //Results Table (List<Object[]>)
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> l1 = new ArrayList<String>();
        l1.add("A1");
        l1.add("B1");
        l1.add("C1");
        results.add(l1);
        List<String> l2 = new ArrayList<String>();
        l2.add("A2");
        l2.add("B2");
        l2.add("C2");
        results.add(l2);
        model.put("results",results);
        response.setContentType( "application/ms-excel" );
        response.setHeader( "Content-disposition", "attachment; filename=myfile.xls" );         
        return new ModelAndView(new MyExcelView(), model);
    }