$('.click').click(function() {

var content = "<img src='test.jpg'> <p>lorum ipsum ipsum ipsum </p>"
// replace the contents of the div with the new contents
$('#content-container').html(lcontent);

// cancel the default action of the link by returning false
return false;
});