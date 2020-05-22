$.ajax({
           type: "POST",
            url: "readXY.jsp", //print array as JSON, XML, or CSV-like text there
            data: {incrementa:true},
            dataType: "html", //change this to JSON, XML, or text as needed
            success: function(msg)
            {
               //msg here is the response from the JSP you are calling, 
               //so whatever you print to response there 
               //is in this variable
               alert("Ok");
               update_coordinate_javascript(msg); //parse the msg in there
            },
            error: function()
            {
              alert("Fail");
            }
          });