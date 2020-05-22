function processRequest() {
var result = jQuery.ajax ({
    url: "your.url",
    method: "post",
    async: false,
    data: ""
});

// Create JS object from JSON
var message = jQuery.parseJSON(result.responseText);

// Now you can show your message
if(message.isLoginSuccess) {
    alert("Welcome");
}else{
    alert("Login Failed");
}
}