$(function () {
    $('#submit_button').click(function () {
        var finalidlist = '';
        for (i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked === true) {
                if (finalidlist.length > 0) {
                    finalidlist += ',';
                }
                finalidlist += checkboxes[i].name;
            }
        }
        $.ajax({
            url: 'submit.jsp',
            type: 'post',
            dataType: 'html',
            async: false,
            data: {ids: finalidlist}
        }
    };
});