FB.init({ 
        appId:'${appId}', 
            cookie: false, 
        status: true, 
        xfbml: true 
    });

FB.getLoginStatus(function (response) {
        if (response.session) {
                alert("here");
        }
});