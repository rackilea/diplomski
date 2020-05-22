// main function for calling your server-side method
function file2(id) {
    $.get("file2?id=" + id, function(data) {
        $("#result").html(data);
        setTimeout(function() {
            file2(id);
        }, 5000);
    });
}

// run it once after 5 seconds and then in will run itself after that
setTimeout(function() {
    file2(id);
}, 5000);