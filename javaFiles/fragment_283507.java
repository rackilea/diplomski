$('#table tbody').on('click', 'tr', function() {
  var idx = table.row(this).index();
  var vName = document.getElementById("userName");

  for (i in vName.options) {
    //I test on the innerText here because FF doesn't support it
    var optionText = typeof vName.options[i].innerText !== 'undefined' ? vName.options[i].innerText : vName.options[i].textContent;
    if (optionText === table.cell(idx, 7).data()) {
      vName.selectedIndex = i;
      break;
    }
  }
});