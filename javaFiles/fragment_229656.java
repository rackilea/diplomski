$(".status").each(function () {
    var that = $(this);
    $(this).find('option').filter(function (index) {
        console.log($(this).parent().next(":hidden").val());
        return $(this).val() === that.next(":hidden").val()
    }).prop('selected', true);
});