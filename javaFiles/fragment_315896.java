$(document).ready(function() {
    var getdata1;
    var getdata2;
    $.post("GetItemCode", function(data) {
        getdata1 = data.codeList;
        getdata2 = data.nameList;
    });
});