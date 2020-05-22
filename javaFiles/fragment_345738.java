$(document).ready(function() {
    $('#radioButton').click(function() {
        var tableText = '<table id="newTable">';
            tableText += '<tr>';
                tableText += '<td>';
                    tableText += $('#importantColumnData').html();
                tableText += '</td>';
            tableText += '</tr>';
        tableText += '</table>';
        $('#firstTable').after(tableText);
    });
});