.
.
var $this = $(this);
$.ajax({
        method: "POST",
        url: "/api/holidays",
        data: request,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            $("#form_result").text("Submitted succesfully");
            $this.prop('display', 'hidden');
        },
        error: function (error) {
            $("#form_result").text("Error: creating the request");
            $("#submitbtn").prop('disabled', false);
        }
    });