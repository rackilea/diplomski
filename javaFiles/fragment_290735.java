$.get('someservlet', function(responseJson) {
alert(responseJson);
var $ul = $('<ul>').appendTo($('#somediv'));
$.each(responseJson, function(index, item) {
$('<li>').text(item).appendTo($ul);
});
});