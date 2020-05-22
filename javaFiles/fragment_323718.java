val messageTemplate = extractEmailTemplateValue("retrieveNextOnCallAndSendMail")?.let {
    messageTemplateAccessPoint.findByID(it) 
} ?: throw IllegalStateException (“Todo”)

val listOfMailRecipient = dataHubCommunicator.listOfOnCallToSendNotificationFromDataHub(time)?.let { 
    onCallListToMailRecipient.buildMailRecipientFromOnCalls(it) 
} ?: throw IllegalStateException (“Todo”)

emailSender
    .sendNotificationToOnCallPersons(listOfMailRecipient, messageTemplate, trial).also{
    println("Message Has been sent Successfully")
}