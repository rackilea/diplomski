$.ajax( "home/search-menu" )
  .done(function(result) {
    alert(result.data[0].itemName);
  })
  .fail(function() {
    alert( "error" );
  })
  .always(function() {
    alert( "complete" );
  });