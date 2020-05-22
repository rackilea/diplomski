$(window).load(function(){
    $.ajaxSetup({
        statusCode: {
            401: function(){
                    location.reload(); // or window.location="http://www.example.com"
                }
        }
    });
});