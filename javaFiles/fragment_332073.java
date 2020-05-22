$(document).on("submit", "#someform", function(event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function(response) {
        // ...
    });

    event.preventDefault(); // Important! Prevents submitting the form.
});