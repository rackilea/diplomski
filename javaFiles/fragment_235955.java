$.ajax({
type : "POST",
contentType:false,
url : "CIMtrek_Compliance_Daily_Shipments_FileUpload",
data: $("#your_form").serialize(),
    success: function (msg) {
        global.getElementById("CIMtrek_uploadedFileName").innerHTML=msg;
         alert("File Uploaded");
    }
});