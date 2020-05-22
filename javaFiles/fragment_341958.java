function handleFileUpload() {
     console.log("handleFileUpload called");
     var url = "http://myserver:8181/bootstrap/rest/upload/license";
     var file = $('#file_upload').get(0).files[0];
     var formData = new FormData();
     formData.append('file', file)
     $.ajax({
        url: url,
        type: "post",
        data: formData,
        processData: false,
        contentType: false,
        success: function(){
           $("#file_upload_result").html('submitted successfully');
        },
        error:function(){
          $("#file_upload_result").html('there was an error while submitting');
        }   
    }); 
  }