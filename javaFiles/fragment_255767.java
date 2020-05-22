$.ajaxSetup({
    contentType: "application/json; charset=utf-8" 
});

function request(path, params, method) {
method = method || "POST";

$.ajax({
    url: path,
    type: method,
    data: params,
    dataType: "json",
    contentType: "application/json; charset=utf-8",
    success: function (result) {
        //do something
    },
    error: function (xhr, ajaxOptions, thrownError) {
        //do something
    }
});
}