if (response != null && response != "") {
    var EditBlockBeanArray = JSON.parse(response);

    var _html = '<table class="table table-bordered table-striped">';
    _html += '<tr>';
    _html += '<th>Blockk No</th>';
    _html += '<th>Lott No</th>';
    _html += '<th>Extentt</th>';
    _html += '<th>Land Value</th>';
    _html += '<th>On Booking Amount</th>';
    _html += '</tr>';

    var i = 0;
    while (i < EditBlockBeanArray.length) {
        var ebbObject = EditBlockBeanArray[i];

        _html += '<tr class="tblRw" id="row' + i + '">';
        _html += '<td><input type="text" class="form-control" size="10" id="blockNo' + i + '" value="' + i + '">' + ebbObject.blockNo + '</td>';
        _html += '<td><input type="text" class="form-control" size="10" id="lotNo' + i + '">' + ebbObject.lotNo + '</td>';
        _html += '<td><input type="text" class="form-control" size="10" id="extent' + i + '">' + ebbObject.extent + '</td>';
        _html += '<td><input type="text" class="form-control" id="land_value' + i + '">' + ebbObject.landValue + '</td>';
        _html += '<td><input type="text" class="form-control" size="10" id="onbookingamount' + i + '">' + ebbObject.onBookingAmount + '</td>';
        _html += '</tr>';

        i++;
    }

    _html += '</table>';
    document.getElementById('results').innerHTML = _html;
} else {
    /* Your error code goes here */
}