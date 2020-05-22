function submitForm(name){
   //All this would be very easy if you were using jQuery
   var nameElem = document.getElementById(name);
   //get values for selected row
   var imageVal = nameElem.getElementsByClassName("image_td")[0].innerHTML;
   var priceVal = nameElem.getElementsByClassName("price_td")[0].innerHTML;
   var typeVal = nameElem.getElementsByClassName("type_td")[0].innerHTML;
    //set the values to submit
   document.getElementById("name_to_submit").value = name;
   document.getElementById("image_to_submit").value = imageVal;
   document.getElementById("price_to_submit").value = priceVal;
   document.getElementById("type_to_submit").value = typeVal;

   document.myForm.submit(); //finally submit the form
}