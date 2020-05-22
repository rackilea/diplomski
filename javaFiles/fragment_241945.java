protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ArrayList<String> list = new ArrayList<String>();

    String query="Select GNAME from tbGroup";
    ps1 = con.prepareStatement(query);
    rs1=ps1.executeQuery();

    while(rs1.next()){
         list.add(rs1.getString("GNAME"));
    }

    //set flag
    boolean flag = true;

    Gson gson = new Gson();

   response.setContentType("application/json");
   response.setCharacterEncoding("UTF-8");          
   PrintWriter out = response.getWriter();    

   out.write(gson.toJson(new ResponseResult(flag, list)));     
   out.flush();
}