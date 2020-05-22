// Do your thing to prepare them.
var param1 = "value1";
var param2 = "value2";

// Now send it as JS object.
$.get('daoServlet', { param1: param1, param2: param2 }, function(responseText) {
    // ...
});