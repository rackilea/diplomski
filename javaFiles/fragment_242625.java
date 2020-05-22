$(document).ajaxError(function( event, jqxhr, settings, exception ) {
    if (jqxhr.status == 403 ) {
      // output custom error
    } else {
      // ...other errors...
    }
  });