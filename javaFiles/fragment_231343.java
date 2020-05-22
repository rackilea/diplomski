myFunction2 = function (i){
  //get selection table
  var table = document.getElementById('selected-players');

  //get the row to be copied over
  var copyRow = document.getElementById('player-listing-'+i).cloneNode(true);

  //change the id attribute on the copied row
  copyRow.setAttribute('id', 'selected-row-'+i);

  //remove the add button on the copy (<td> and <button>)
  copyRow.removeChild(copyRow.firstChild);  
  copyRow.removeChild(copyRow.firstChild);

  //add copied row to new table
  table.appendChild(copyRow);
}