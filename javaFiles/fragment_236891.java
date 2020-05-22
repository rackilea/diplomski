setInterval(updateTimestamps,30000);
var ids = new Array();

function updateTimestamps(){
    $(".timestamp").each(function(i){
    var obj = new Object();
    obj.id = $(this).attr("postID");
    obj.timestamp = $(this).attr("postdate");
        ids.push(obj);
    }

    $.post("http://site.com/ajax/humanTime.php", {"time": ids}, function(data) {
        for (i = 0; i < data.length; i++) {
            $("#" + data[i].id).html(data[i].content);
        }
    }, "json");
}