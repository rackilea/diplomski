$('#btnLogin').on('click', loginAction);
$('#loginFrm').on('submit', loginAction);

function loginAction(eventObject)  {
    eventObject.preventDefault();
    var userEmail = $('#email').val();
    ...