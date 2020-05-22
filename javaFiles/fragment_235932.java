Parse.Cloud.define("sendEmail", function(request, response) {
var recipientJavaArray = request.params.toEmail;
var recipientArray = JSON.parse(recipientJavaArray);
var recipients = [];
for (var i = 0; i < recipientArray.length; i++) {
    var recipientObject = {};
    recipientObject["email"] = recipientArray[i];
    recipients.push(recipientObject);
}

var Mandrill = require('mandrill');
Mandrill.initialize('1C7****************fOQ');
Mandrill.sendEmail({
    message: {
        text: request.params.text,
        subject: request.params.subject,
        from_email: request.params.fromEmail,
        from_name: request.params.fromName,
        to: recipients
    },
    async: true
},{
    success: function(httpResponse) {
        console.log(httpResponse);
        response.success("Email sent!");
    },
    error: function(httpResponse) {
        console.error(httpResponse);
        response.error("Uh oh, something went wrong");
    }
});
});