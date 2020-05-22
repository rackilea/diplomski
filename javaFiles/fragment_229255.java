//If you need this functionality for only one check-box. 
 //Add a specific class/id to that particular check-box.
 $(".specific-checkbox").on('change', function () {
   if ($(this).is(':checked')) {
      submitButt.removeAttr('disabled');
   } else {
       submitButt.attr('disabled','disabled');
   }
});