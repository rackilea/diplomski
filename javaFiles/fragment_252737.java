$(document).ready(function() {
    $('form input[type=submit]').click(function(event) {
        event.preventDefault();
        var formData = $(this).closest('form').serialize();
        $.ajax({
                type: 'POST',
                url: 'one.php',
                data: formData,
                dataType: 'json',
                success: function(data) {
                   // do your work here
                }
            });
     });
});