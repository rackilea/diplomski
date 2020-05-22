afterSubmit: function (response) {
    var myInfo = '<div class="ui-state-highlight ui-corner-all">'+
                 '<span class="ui-icon ui-icon-info" ' +
                     'style="float: left; margin-right: .3em;"></span>' +
                 response.responseText +
                 '</div>',
        $infoTr = $("#TblGrid_" + $.jgrid.jqID(this.id) + ">tbody>tr.tinfo"),
        $infoTd = $infoTr.children("td.topinfo");
    $infoTd.html(myInfo);
    $infoTr.show();

    // display status message to 3 sec only
    setTimeout(function () {
        $infoTr.slideUp("slow");
    }, 3000);

    return [true, "", ""]; // response should be interpreted as successful
}