$.ajax({
    type: "POST",
    url: URL,
    data: reqBody,
    dataType: "json",
    success: function(data, textStatus) {
        if (data.redirect) {
            // Redirect here
            window.location.href = data.redirect;
        }
        else {
            // No redirection.
        }
    }
});