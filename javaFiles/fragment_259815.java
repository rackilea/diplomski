$(document).ready(function () {

    $("#selectCustomer").change(function (event) {
        fire_ajax();
    });

});

function fire_ajax() {

    var name = $("#selectCustomer").val();
    
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/"+name,
        dataType:'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
    var options = "<option selected disabled>select a project</option>"
    $.each(data, function(index, value) {
     options += "<option value=\""+value.name+"\">"+value.name+" </option>"
   });
                   
            $('#selectProject').html(options);
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}