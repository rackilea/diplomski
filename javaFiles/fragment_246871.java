$.ajax({
    type: "POST",
    url: "save_user",
    data: $("#user").serialize(),
    success: function(data) {
    //get response data and process it 
     ...
    }
});