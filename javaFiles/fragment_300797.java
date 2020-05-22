$(function() {
  $('button[type=button]').on('click',function() {
    var upForm = $('form').get(0);
    var $form = new FormData(upForm);
    $.ajax({
        url:'login.do', 
        data: $form,
        type: 'POST',
        processData: false,
        contentType: false,
        success: function(responseText) {
            var data = responseText.pList;
            $.each(data, function(index, tmp) {
                var table1 = $('table>tbody').get(0);
                var row = table1.insertRow();
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
            });
            $('#tabel').tablesorter();
        }
    });
  });
})