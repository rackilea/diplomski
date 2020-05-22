$.getScript( "http://maps.google.com/maps?file=api&v=2&key=<%=googleMapKey%>&callback=initialize" )
  .done(function( script, textStatus ) {
    //load your google maps stuff
  })
  .fail(function( jqxhr, settings, exception ) {
    //hide placeholder for google maps / display error
});