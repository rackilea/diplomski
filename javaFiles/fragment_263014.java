Content content;
if(template == "acceptedEmail")
    content = views.html.acceptedEmail.render(incomingBlob,relatedBlob,rule)
else if (template == "somethingElse")
    content = views.html.somethingElse.render(incomingBlob,relatedBlob,rule)
.....