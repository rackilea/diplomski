// create master grid
$("#table1").jqGrid({
    datatype: "json",
    url: "masterGridUrl",
    onSelectRow: function (rowid, state) {
        if (state) { // if not the same row was previously selected
            // refresh detail grid
            $("#table2").jqGrid("setGridParam", { datatype: "json"})
                .trigger("reloadGrid", [{page: 1}]);
        }
    },
    ... // another options
});

// create details grid without filling the data initially
$("#table2").jqGrid({
    datatype: "json", // we use "local" instead of "json" to have to request to the server
    url: "JGridA",
    postData: {
        action: "abc",
        hidden: function () {
            // id of currently selected row
            return $("#table1").jqGrid("getGridParam", "selrow");
        }
    },
    ... // other options
});