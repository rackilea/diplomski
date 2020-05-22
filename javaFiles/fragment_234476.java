$('form').submit(function(event){
    if($('#username').val().trim().length == 0 && $('#password').val().trim().length == 0){
        event.preventDefault();
        window.location.href = '/app/registration'
    }
});