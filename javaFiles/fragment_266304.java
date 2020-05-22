tableDnD.onDrop = function(table, row) {
    var rows = this.table.tBodies[0].rows;
    var debugStr = "rows now: ";
    for (var i=0; i<rows.length; i++) {
        debugStr += rows[i].id+" ";
    }

    document.getElementById('debug').innerHTML = 'row['+row.id+'] dropped<br>'+debugStr;
}