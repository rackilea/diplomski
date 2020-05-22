..., function(data) {
    if (data.hasEmail) {
        window.location = data.location;
    } else {
        $("#CommViaEmail").fadeIn("normal");   //view form to let user enter his email
    }
}