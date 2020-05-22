function setRequestList(jqgrid_data,status){
    var title = [];
    if(status == '0'){
        title = ['No', 'nick',... ];
    }else if(status == '1'){
        title = ['No', 'name', ... ];
    }
    var colmodel = [];
    $("#requestList").jqGrid("GridUnload");
    jQuery("#requestList").jqGrid({
        data : jqgrid_data,
        datatype : "local",
        height : 'auto',
        colNames : title,
        colModel : [{
            name : 'col1',
            index : 'seq',
            align : 'center',
            sortable : false
        }
        ...