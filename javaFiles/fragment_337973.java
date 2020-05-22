function checkProgress() {
    $.getJSON('progressServlet?processId=someid', function(progress) {
        $('#progress').text(progress + "%");
        $('#progress .bar').width(progress);

        if (parseInt(progress) < 100) {
            setTimeout(checkProgress, 1000); // Checks again after one second.
        }
    });
}