$('#addButton').bind('click', function() {
    count = document.getElementById("dataTable").getElementsByTagName("tr").length;
    $('#counter').html(count);
    $('#hiddenField').val(count);
});
$('#deleteButton').bind('click', function() {
    count = document.getElementById("dataTable").getElementsByTagName("tr").length;
    $('#counter').html(count);
    $('#hiddenField').val(count);
});