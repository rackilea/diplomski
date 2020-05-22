function tableToArray(tbl, opt_cellValueGetter) {
  opt_cellValueGetter = opt_cellValueGetter || function(td) { return td.textContent || td.innerText; };
  var twoD = [];
  for (var rowCount = tbl.rows.length, rowIndex = 0; rowIndex < rowCount; rowIndex++) {
    twoD.push([]);
  }
  for (var rowIndex = 0, tr; rowIndex < rowCount; rowIndex++) {
    var tr = tbl.rows[rowIndex];
    for (var colIndex = 0, colCount = tr.cells.length, offset = 0; colIndex < colCount; colIndex++) {
      var td = tr.cells[colIndex], text = opt_cellValueGetter(td, colIndex, rowIndex, tbl);
      while (twoD[rowIndex].hasOwnProperty(colIndex + offset)) {
        offset++;
      }
      for (var i = 0, colSpan = parseInt(td.colSpan, 10) || 1; i < colSpan; i++) {
        for (var j = 0, rowSpan = parseInt(td.rowSpan, 10) || 1; j < rowSpan; j++) {
          twoD[rowIndex + j][colIndex + offset + i] = text;
        }
      }
    }
  }
  return twoD;
}