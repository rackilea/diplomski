$(document).ready(function() {
    $('.ibutton').click(function(e) {
        e.preventDefault();  // add preventDefault()
        var ajaxdata = $("#country").val();

        // don't send data like this
        // var value = "country=" + ajaxdata;
        // try like below, as an object
        var value = {'countr' : ajaxdata};

        $.ajax({
            url: "saveIt",
            type: "POST",
            data: value,
            cache: false,
            success: function(data) {
                alert("load success");
            }
        });
    });
});