$(document).ready(function() {
    $('#form').submit(function() {
        var searchtext = $('#search').val();
        $.ajax({
            type:       "post",
            url:        "/PathToServlet",
            data:       "q=" + searchtext ,
            success:    function(data) {
              alert('Data Recieved : ' + data);
            }
        });

    return false;
    });
});