$(document).ready(function(){
    $("#click").on('click', function() {
        var html = '<option value="val1">Val-1</option><option value="val12">Val-12</option>';
        $("#select").append(html);

    });
});