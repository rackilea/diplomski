function decline(){

 $("#dialog-container").dialog( 'close' );
 /*****run ajax to kill session of current user and return to login page ******/
  $.ajax({ url: '//yoursite.com/termsofservice/declinedkill.php',
         data: {},
         type: 'get',
         success: function(output) {
                  }
});
}