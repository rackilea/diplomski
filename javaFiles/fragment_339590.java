$("tr").click(function() {
var href  = $(this).find("a").attr("href");
 $.ajax({
                cache:false,
                dataType:"html",
                data:"yourparameter="+href,
                type: "POST",
                url: "yourServletContextPath",
                success: function(data)
                    {
                        //console.log(data);
                        alert("success"+data);
                    },
                error: function(exception)
                    {
                    alert("error");
                    }
                });
});