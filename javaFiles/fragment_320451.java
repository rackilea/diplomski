$("#myform").on("submit", function(e) {
    e.preventDefault();
    e.stopPropagation();
    $.post('userRegistrationServlet',{
            uName : $('#uName').val(),
            psw : $('#psw').val()},
            function(responseText) {
                alert(uName);
                alert("Login Successfully..!");
            });
});