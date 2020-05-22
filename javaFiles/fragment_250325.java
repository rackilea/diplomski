$("#uploadForm").submit(function(e) {
    e.preventDefault();
    var $form = $("#uploadForm");
    var fd = new FormData($(this)[0]);
    console.info(fd);
    $.ajax({
        type : 'POST',
        url : $form.attr('action'),
        data : fd,
        cache : false,
        processData : false,
        contentType : false,
        success : function(response) {
            console.info(response);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            console.info("Status: " + XMLHttpRequest);
            alert("Status: " + textStatus);
            alert("Error: " + errorThrown);
        }
    });
});