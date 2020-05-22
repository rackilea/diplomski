$('#name').on('change', function() {
  var vName = document.getElementById("userName");
  
  for (i in vName.options) {
    var optionText = typeof vName.options[i].innerText !== 'undefined' ? vName.options[i].innerText : vName.options[i].textContent;
    
    if (optionText === $(this).val()) {
      vName.selectedIndex = i;
      break;
    }
  }
});