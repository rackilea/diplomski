public SendCVConfirmationNotification(String enroleeName, String companyName,
  String nickName, List<VisibilityInfo> visibilityInfo, boolean hasClaims,
  boolean hasReturns, String cvURL, String emailId){
    this.enroleeName = enroleeName;
    this.companyName = companyName;
    this.nickName = nickName;
    this.visibilityInfo = visibilityInfo;
    this.hasClaims = hasClaims;
    this.hasReturns = hasReturns;
    this.cvURL = cvURL;
    this.emailId = emailId;
}