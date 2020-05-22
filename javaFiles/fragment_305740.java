$.ajax(
    {url: "/pathtoserver/",
     type: "POST",
     contentType: "application/json",
     data: JSON.stringify({url:$('#url').val()}),
     success: function(data) { handleValidateResponse(data); console.log(data); }
    });