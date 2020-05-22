$.post("Login", params, function(data){
            if(!data.error)
                window.location.href = "http://example.com/UserInfo/";
            else
                alert(data.error);
        });