$.ajax({
    dataType: "jsonp",
    url: serviceURL
}).done(function ( data ) {
  console.log(data);
});