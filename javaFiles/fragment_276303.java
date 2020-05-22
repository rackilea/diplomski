let onoff = document.getElementById('onoff'); // checkbox id
let toggle = document.querySelectorAll('.toggle-txt');

onoff.addEventListener('change', function() { 
  // run function each time when checkbox is changing
  // this == the element, which run the function (here == checkbox)
  this.closest('.main-switch').classList.toggle('on');
  // find the closest parent with class '.main-switch'
  
  for (let i = 0; i < toggle.length; i++) {
    toggle[i].textContent = (this.checked) ? "APPROVED" : "DISAPPROVED";
  }
  // Google → Ternary operator.
  // (check the condition) ? (return value if true) : (value if false)
  
  // property 'checkbox.checked' always contains "true" or "false"
  //
});