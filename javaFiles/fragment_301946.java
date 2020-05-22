@RequestMapping(value="/dwn.htm",method=RequestMethod.GET)
public void dwAppFm(HttpSession session,HttpServletRequest request,HttpServletResponse response,@RequestParam String id) throws IOException,InterruptedException
{           
         String savePath="/tmp/";//PDF file Generate Path
         String fileName="PDFFileName.pdf"; //Pdf file name
         File download = new File(savePath, fileName);

         try {
           Process process = printApp(id, download.getPath());
           int status = process.waitFor();
           if (status == 0) {
             response.setContentType("application/pdf");
             response.setContentLength((int)download.length());              
             String headerKey="Content-Disposition";
             String headerValue=String.format("attachment;filename=\"%s\"", download.getName());
             StreamUtils.copy(new FileInputStream(download), response.getOutputStream())
           } else {
             // do something if it fails.
           }

         } catch (IOException ioe) {
           // Do something to handle exception
         } catch (InterruptedException ie) {
           // Do something to handle exception
         }

       }    

}

public Process printApp(String id, String pdf) throws IOException {    
        String urlPath="http://localhost:8080/proj";
        urlPath+="/genApp.htm?id="+id;//generate url to execute wkhtmltopdf 
        String wxpath="/home/exm/wkhtmltopdf";//the path where wkhtmltopdf located  
        String command = wxpath+" "+urlPath+" "+pdf;        
        return Runtime.getRuntime().exec(command);     
}