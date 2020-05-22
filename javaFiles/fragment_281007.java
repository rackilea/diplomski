$('#excel').click(function(){
    var fromdate = $('#fromdate').val();
    var todate = $('#todate').val();
    if(fromdate && todate) {
        var url = 'excel?fromdate=' + fromdate + '&todate=' + todate;
        $('#download-frame').attr('src', url);
    }
});