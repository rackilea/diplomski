$(function() {
var url = "/api/route";

$('form').submit(function() {
    var json = JSON.stringify($('form').serializeObject());
    request(url, json);
    return false;
});
});