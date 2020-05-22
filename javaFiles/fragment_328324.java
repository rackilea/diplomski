function addRowsViaAJAX() {

    var d = new Date(); // IE hack to prevent caching

    $.getJSON('/ControllerName/ActionName', { Data: $('#MyForm').serialize(), Date: d.getTime() }, function(data) {
        // callback on success
        alert(data);
    }, 'json');
}