$('#submit-date').click(function() {
    var processDate = $('#processDateForm').val();
    alert(processDate);
    $.ajax({
        /* type : "POST", */
        url : "launchapptest",
        /* contentType: "application/json; charset=utf-8", */
        data : "processDateInput="+processDate,
        dataType : "json",
        async: true,
        success : function(result) {
            alert("Success");
        }
    });