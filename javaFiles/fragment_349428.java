$(document).ready(function(){
     $("#submit").click(function () 
       var data = $('#form1').serialize();
       alert(data);
       $.post("submitForm", data, function (result) {
            if (result == "success") {
              alert("Record added!");
            } else {
                alert("Could not add Record!");
            }
       });
    });
   });