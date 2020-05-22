$.ajax({
                    async: true,
                    url : "Servlet1?action=action1", // Here you set the parameter
                    method : "GET",
                    dataType : "json",
                    contentType: "application/json; charset=utf-8",  
                    success : function(tableValue) {
                     addTable(tableValue)                               
                    }                                
                });