$.ajax({
    url : "LoginServlet",
    type : "post",                      
    cache : false,
    async : false,          
    dataType : "json",
    data : params,
    contentType : "application/json; charset=utf-8",
    success : function(data) {
                  alert("hello");
            }
       });