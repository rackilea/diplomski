<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>


<html>
<head>
    <%@ page
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Test</title>
</head>
<body>
<form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
<table>
    <tr>
        <p>Bir seferde maksimum 20 dosya yükleyebilirsiniz.</p>
    </tr>
    <tr>
        <td><input type="file" name="myFile" multiple="multiple" size="20" style="width: 522px;"></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Yükle">
        </td>
    </tr>
</table>
</form>
</body>
</html>