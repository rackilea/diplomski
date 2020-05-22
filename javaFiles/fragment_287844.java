function submitHiddenForm(firstName, phone) {

       document.getElementById("firstname").value = firstName;
       document.getElementById("phone").value = phone;
       // attach a name attribute to your form tag
       // submit the form
       document.myForm.submit();
   }