public class FileDownload extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        String filename = "E:\\workbook.xls";


        ServletOutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(filename);

        response.setContentType("application/vnd.ms-excel");
        response.addHeader("content-disposition",
                "attachment; filename=" + filename);

        int octet;
        while((octet = in.read()) != -1)
            out.write(octet);

        in.close();
        out.close();
    }


}