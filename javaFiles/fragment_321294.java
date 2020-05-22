$(".deleteLink").each(function (index) {
    let path = $(this).attr("href");
    $(this).click(function(e) {
        e.preventDefault(); // prevent default behaviour

        $.ajax({
            url: path ,
            type: 'DELETE',
            success: function(result) {
                // Do something with the result
            }
        });
    });
});