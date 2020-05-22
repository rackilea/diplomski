public NSPNotificationRequest(String transactionId, String clientId,
  String destinationAddress, SendCVConfirmationNotification sendCVConfirmationNotification,
  String locale, String mediaType, String pageId){
    this.transactionId = transactionId;
    this.clientId = clientId;
    this.destinationAddress = destinationAddress;
    this.sendCVConfirmationNotification = sendCVConfirmationNotification;
    this.locale = locale;
    this.mediaType = mediaType;
    this.pageId = pageId;
    //if this class includes any other properties, include them accordingly
}