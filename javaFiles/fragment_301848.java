$( document ).ready(function() {
     $.subscribe('gridEstudiosComplete', function() {
            var selRowIds=new Array();
            selRowIds=$('#gridEstudios').jqGrid("getDataIDs");
            var records = jQuery("#gridEstudios").jqGrid('getGridParam', 'records');
            var pagesize = jQuery("#gridEstudios").jqGrid('getGridParam', 'rowNum');
            var postdata = jQuery("#gridEstudios").jqGrid('getGridParam', 'postData');
            var curpage = postdata.page
            var totalpages = postdata.total
            // if records < pagesize I add empty rows until I have 5 (this works ok) else I have to calculate how many empty rows I have to add to the last page (it doesn't work ok, I added pictures below)
            if (records < pagesize) {
                for (i = records - pagesize; i < pagesize; i++) {
                    $("#gridEstudios").addRowData(records + i, {});
                }
            } else if (records > pagesize && records % pagesize != 0 && curpage == totalpages) {
                rowsToAdd = pagesize - (records % pagesize);
                while(rowsToAdd > 0) {
                    $("#gridEstudios").addRowData(records + 1, {});
                    records = records + 1;
                    rowsToAdd = rowsToAdd - 1;
                }
            }
    });