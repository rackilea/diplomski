$.ajax({
    type: 'GET',
    url:  prefix + "/throwCustomized4ExceptionHandler",

    async: true,
    success: function(result) {
        alert('Unexpected success !!!');
    },
    error: function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + " " + jqXHR.responseText);
    }
});