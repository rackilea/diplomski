function addToTable(data) {
  var dataTable = document.getElementById("tabel");
  for(var i = 0; i<data.pList.length; i++) {
    var row = dataTable.insertRow();
    var tmp = data.pList[i];

    var cell0 = row.insertCell(); //nimi
    var cell1 = row.insertCell(); //aadress
    var cell2 = row.insertCell(); //synd
    var cell3 = row.insertCell(); //email
    var cell4 = row.insertCell(); //muuda
    var cell5 = row.insertCell(); //kustuta

    cell0.innerHTML = tmp.name;
    cell1.innerHTML = tmp.address;
    cell2.innerHTML = tmp.syKP;
    cell3.innerHTML = tmp.email;
    cell4.innerHTML = '<button class="btn button-default"><span class="glyphicon glyphicon-pencil"></span></button>';
    cell5.innerHTML = '<button class="btn button-default"><span class="glyphicon glyphicon-remove-sign"></span></button>';
  }
}