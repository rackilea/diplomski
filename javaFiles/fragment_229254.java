$(document).ready(function () {
  var checkboxes = $("input[type='checkbox']"),
    submitButt = $("#submit");

  function allChecked() {
    var result = true;
    checkboxes.each(function() {
        if(!$(this).is(":checked")) {
           result = false; 
        }  
    });
    return result;
  }

  checkboxes.on('change', function(e){
    e.preventDefault();
    if(!allChecked()) {
        submitButt.attr('disabled','disabled');
    } else {
        submitButt.removeAttr('disabled');       
    }
  });

});