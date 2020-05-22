$(document).ready(function(){
    var producer = "producer";
    var model = "model";
    var price = "1";
    var editUserRequest = new Object();
    editUserRequest.producer=producer;
    editUserRequest.model=model;
    editUserRequest.price=price;
    $.ajax({
        url : 'ajaxtest',
        data: JSON.stringify(editUserRequest),
        type: "POST",
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',

        success : function(data) {
            alert("success");
            console.log(data);
        },
        error:function(data) {
            alert("errorxxx");
            console.log(data);
        }
    }); 

});