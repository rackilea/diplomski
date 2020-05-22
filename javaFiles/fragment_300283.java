function changeFormValueAndSubmit(buttonName) {
   var formData = $('form').serialize();
   jQuery.post('/path', formData, function(d) {
         // handle response
   });

    ...
}