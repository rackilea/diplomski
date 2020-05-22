afterSubmit: function () {
    setTimeout(function () {
        $(".ui-jqgrid-btable").trigger("reloadGrid", {fromServer: true});
    }, 50);
    return [true, "", ""];
}