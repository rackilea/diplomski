$(window).load(function() {

    jsf.ajax.addOnEvent(function (data) {
        if (data.status === "success") {
            //your code to show the panel with errors goes here
        }
    });

});