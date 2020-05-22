<script>
$(document).ready(function() {
    var deleteLink = $("a:contains('Delete')");
    $(deleteLink).click(function(event) {
        var conBox = confirm("Are you sure ?");
        if(conBox){
        $.ajax({
            url: $(event.target).attr("href"),
            type: "DELETE",

            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function() {
                var tr = $(event.target).closest("tr");
                tr.css("background-color","#000000");
                tr.fadeIn(1000).fadeOut(200, function(){
                tr.remove();})
            }
        });
        } else {
            event.preventDefault();
        }
        event.preventDefault();
    });
});
</script>