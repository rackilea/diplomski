//controller
Content content = views.html.mainView.render(template,incomingBlob,relatedBlob,rule);

//view - mainView.scala.html
@(template: String, incomingBlob: ?,relatedBlob: ?,rule: ?))

@if(template == "acceptedEmail") {
    @acceptedEmail(incomingBlob, relatedBlob, rule)
}