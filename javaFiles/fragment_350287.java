function login() {
    $.ajax({
        type: 'POST',
        url: url, //Url of login endpoint
        data: DATA, //Now here you would want to send a payload i.e. your username and password data
        dataType: 'json',
        contentType: 'application/.json',
        success: function(data) { 
                    //HERE 'data' would represent your true or false that came back from the server. 
                    //You can do stuff here with the response
                 },
        error: function(jqXHR, textStatus, errorThrown) {
                    //IF ERROR then this code would be executed.                        
               }
    });
}