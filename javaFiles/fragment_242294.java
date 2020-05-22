$("a[id$='search']").click(function() {
    var input = $("<input>").attr("type", "hidden").attr("name",   "myForm:search").val("myForm:search");
    $('#myForm').append($(input));
    $("p#dialog-email").html(titleVar);
    $('#dialog').dialog('open');
});