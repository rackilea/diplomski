// Attach a submit handler to the form
$("#loginForm").submit(function( event ) {

    // Stop form from submitting normally
    event.preventDefault();

    // Get some values from elements on the page:
    var $form = $( this );

    // We want to customize what we post, therefore we format our data
    var data = "login="+ $('#login').val() +"&passwordHash=" + CryptoJS.MD5($('#password').val());

    // For debugging purposes... see your console:
    // Prints out for example: login=myLoginName&passwordHash=a011a78a0c8d9e4f0038a5032d7668ab
    console.log(data);

    // The actual from POST method
    $.ajax({
        type: $form.attr('method'),
        url:  $form.attr('action'),
        data: data,
        success: function (data) {
            console.log("Hey, we got reply form java side, with following data: ");
            console.log(data);

            // redirecting example..
            if(data === "SUCCESS") {

               window.location.replace("http://stackoverflow.com");

            }

        }
    });

});