$.ajax({
            url:"NewServlet",
            type:"POST",
            dataType:'json',
            data: {list:arr,rel:rel},
            success:function(data){
                // codes....
            }
     });