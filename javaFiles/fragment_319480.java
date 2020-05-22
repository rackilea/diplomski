$('button').on('click', function(e) {
    var pk = '#/openGraph/104';
    var title='title';
    myButton="<input type=\"button\" class = \"openGraph\" value=\""+title+"\" id="+pk+"/\>";
    if ($("#loadAllTitles").find('#' + $.escapeSelector(pk + '/')).length == 0)
        $("#loadAllTitles").append(myButton)
})