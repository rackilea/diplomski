function uploadImage() {

            var file = $('[name="file"]');
            //var imgContainer = $('#imgContainer');

            var formData = new FormData();
            formData.append('file', jQuery('input[type=file]')[0].files[0]);
            var filename = $.trim(file.val());

            if (!(isJpg(filename) || isPng(filename))) {
                alert('Please browse a JPG/PNG file to upload ...');
                return;
            }

             $.ajax({
                url: "http://localhost:8080/EmployeeRegistrationForm/echofile",
                type: "POST",
                data: new FormData(document.getElementById("fileForm")), 
                //data: formData,
                enctype: 'multipart/form-data',
                processData: false,
                aync: false,
                modelAttribute:'uploadedFile',
                headers: {'Content-Type': 'multipart/form-data'},
                contentType: false,
             /*  }).done(function(data) {

                 var img = '<img src="data:' + data.contenttype + ';base64,'
                      + data.base64 + '"/>';
                  alert("success");

             }).fail(function(jqXHR, textStatus) {

                  alert('File upload failed ...');
              });  */

            success: function(response){

                var obj = JSON.parse(response);
                alert(response);

            },

            error: function(){                      
                alert('Error while request..');
            }
        });   
        }