init:function(){
        navigator.geolocation.getCurrentPosition(
            function (position){
                ACC.search.coords = position.coords;
            },
            function (error)
            {
                console.log("An error occurred... The error code and message are: " + error.code + "/" + error.message);
            }
        );

    },