function addRowListener() {
var table = document.getElementsByClassName("v-grid-tablewrapper")[0];
table = table.getElementsByTagName("table")[0];
var rows = table.getElementsByTagName("tr");
for (i = 0; i < rows.length; i++) {
     var currentRow = table.rows[i];
     var createClickHandler = 
     function(row) 
     {
         return function() { 
                                var cell = row.getElementsByTagName("td")[0];
                                    var id = cell.innerHTML;
                                    rowClicked(id);
                           };
     };

    currentRow.onclick = createClickHandler(currentRow);
}
}