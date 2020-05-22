function ConnectionEstablished(ResponseData) {
    if (ResponseData != "")
    {
        //alert("resp"+ResponseData)
        AuthenticationSuccess(ResponseData);
    }
    else
    {
        $('#loading').hide(); //hide the loader!
        alert("Username or Password is incorrect!");
    }
}