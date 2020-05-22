$.ajax({
    type: "get",
    url: $(".user-details-link").attr("href"),
    dataType: "json",
    cache: true,
    error: function(jqXHr,textStatus, errorThrown) {
             alert("Error opening dialog:\n" + errorThrown);
    },
    success: function(data){                    
        $("#email").val(data.email);
        $("#firstName").val(data.firstName);
        $("#lastName").val(data.lastName);
        $("#view-user").removeClass("hidden");
        $("#view-user").dialog(dialogOpts);
        $("#view-user").dialog("open");

    }

});//end ajax