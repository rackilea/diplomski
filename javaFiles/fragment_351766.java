jQuery.ajax({
  type: 'POST',
  url: servletURL,
  data: JSON.stringify(jsArray),
  dataType: 'json',
  contentType: 'application/json'
});