$(document).ready(function() {
  fun_showtextbox();
  $('#select1').change(function() {
    fun_showtextbox();
  })
});

function fun_showtextbox() {
  var select_status = $('#select1').val();
  /* select  from select box then show my text box */

  if (select_status == "y") {
    $('#mobileno_textbox').show(); // By using this id you can show your 
    content
  } else {
    $('#mobileno_textbox').hide(); // otherwise hide   
  }

}