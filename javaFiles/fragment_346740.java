yourForm.onsubmit = setYesCount;

function setYesCount() {
  var count = 0;

  // could use yourForm.getElementsByTagName(),
  // but since the OP didn't provide surrounding HTML:
  var els = document.getElementsByTagName("input");
  for (var i=0; i < els.length; i++) {
    if (els[i].type === "radio" && els[i].checked && els[i].value === "yes")
      count++;
  }
  // add an id attribute to the hidden input
  // for the following to work
  document.getElementById("number_of_yes").value = count;
}