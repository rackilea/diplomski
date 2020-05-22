// Get reference to the submit button
var sub = document.querySelector("button.btn-success");

// Get a reference to both radio buttons as an array
var radBtns = Array.prototype.slice.call(document.querySelectorAll("input[name='data-offer-id']"));


// Loop over the buttons
radBtns.forEach(function(btn){
  // Set each button to have a click event handler
  btn.addEventListener("click", function(){
    // Set the radio button's value as the id of the submit button
    sub.setAttribute("data-offer-id", btn.value);
    
    // Just for testing:
    console.clear();
    console.log(sub);
  });
});