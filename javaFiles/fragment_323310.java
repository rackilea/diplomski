$('#svoAffectedSoftware').change(function() { 
       
        var form_data = {
        svoAffectedSoftware: $("#svoAffectedSoftware").val()
                         };
        
       $.ajax({
                       type: "GET",
                       cache: false,
                       url: "getNewPage.jsp",
                       data: form_data,
                       success: function(data){
                        $("#contentDiv").html(data);
                       }
                   });
              });