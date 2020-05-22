<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.excel2pdfconvert.example.Xls2PDFConvertBean" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>
    Excel2Pdf Api Demo
</title>
    <script type="text/javascript">
        function BeforeConvert() {
            document.getElementById('LabelMessage').innerHTML = 'Please wait...';
            document.getElementById('HyperLinkFile').innerHTML = '';
            document.getElementById('LabelFileSize').innerHTML = '';
            document.getElementById('LabelFileName').innerHTML = '';
        }
    </script> 
</head>
<body>

<form method="post" enctype="multipart/form-data">

    <div>
        <h1>Excel2Pdf Api Demo</h1>
        Upload Excel file:&nbsp;
        <input type="file" name="excel" />&nbsp;
        <input type="submit" name="btnConvert" value="Convert" onclick="BeforeConvert();" id="btnConvert" />
        <br />
        <br />


<% if(ServletFileUpload.isMultipartContent(request)){

    DiskFileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List items = upload.parseRequest(request);

    File uploadedFile = null;
    String[] allowedExt = {"csv", "xls", "xlsx", "xlsb", "xlt", "xltx"};

    // Process the uploaded items
    Iterator iter = items.iterator();
    while (iter.hasNext()) {
        FileItem item = (FileItem) iter.next();

        if (! item.isFormField()) {

            //Check for valid excel extensions
            String fileName = item.getName();
            boolean isValid = false;
             for(String ext : allowedExt){
                 if(fileName.contains(ext)){
                    isValid = true;
                    break;
                 }
             }

             if(isValid){
                 uploadedFile = new File(application.getRealPath("/") + "/" + fileName);
                 item.write(uploadedFile);
             }
        }
    }

    if(uploadedFile == null){
        out.println("<div>Please upload file in following format: csv, xls, xlsx, xlsb, xlt, xltx");
    }else{

        Xls2PDFConvertBean xls2pdf = new Xls2PDFConvertBean();
        xls2pdf.setOutputDir(application.getRealPath("/"));
        xls2pdf.setExcelFile(uploadedFile);
        String resultcode = xls2pdf.doRequest();

        //Remove uploaded file after conversion
        uploadedFile.delete();

        if(resultcode == null || "False".equals(resultcode)){
            out.println("<div>Can not convert file</div>");
        }else{
%>
        <span id="LabelMessage">Conversion successful  </span>
        <br />
        <a id="HyperLinkFile" href="<%= xls2pdf.getFilename() %>" >Click here to open file  </a>

        <br />
        <span id="LabelFileSize">File size: <%= xls2pdf.getFilesize() %></span>
        <br />
        <span id="LabelFileName">File name: <%= xls2pdf.getFilename() %></span>
 <%
            }
        }
    }else{
%>
    <span id="LabelMessage"></span>
<%      
    }
%>


    </div>
</form>

</body>

</html>