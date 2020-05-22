function saveChecksForce() {
  var c = window.document.getElementById("ServerChecklist").rows;
  var checkedservers = "";
  for (var i = 0; i & lt; c.length; i++) {
    if (c[i].cells[1] != null) {
      if (c[i].cells[1].children[0] != null) {
        if (c[i].cells[1].children[0].checked == true) {
          checkedservers = checkedservers + c[i].cells[0].innerHTML + ",";
        }
      }
    }
  }
  window.document.getElementById('ServerList').value = checkedservers;
}