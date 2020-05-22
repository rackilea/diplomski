$("td[id='id']").each(function(e) {
  var elem = $(this)
  var id = elem.text();
  $.ajax({
    type: 'GET',
    url: serviceUrl + id,
    cache: true,
    success: function(data) {
      $.map(JSON.parse(data), function(item) {
      elem.append(' ' + item.FNAME + ' ' + item.LNAME);
  });
})