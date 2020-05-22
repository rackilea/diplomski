$.get('resource/templates/template.html')
        .then(function(body) {

        $(".element").html(body);

        var elementTemplate = doT.template($('#elementAnother').text());

        $('#elementAnotherAnother').html(elementTemplate({}));

        render();
    });