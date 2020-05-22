public static void main(String[] args) {  

      List<VisibilityInfo> visibilityInfo = new ArrayList<>(); 

      List<String> accountNumbers = new ArrayList<>();
      accountNumbers.add("1233");
      accountNumbers.add("6722");       
      visibilityInfo.add(new VisibilityInfo(VisibilityType.FOURTH_PARTY,
        accountNumbers, null));

      List<String> accountNumbers = new ArrayList<>();
      accountNumbers.add("6152");
      accountNumbers.add("1277");       
      visibilityInfo.add(new VisibilityInfo(VisibilityType.OUTBOUND,
        accountNumbers, null));

      Address addr = new Address(Values.addressType, null, 
        null, null, null, "downtown test", "NY", "7539", "US", null);    
      visibilityInfo.add(new VisibilityInfo(VisibilityType.OUTBOUND,
        null, addr));

      SendCVConfirmationNotification scv = new SendCVConfirmationNotification(
        Values.enroleeName, Values.companyName, Values.nickName, visibilityInfo, 
        Values.hasClaims, Values.hasReturns, Values.cvURL, null); 

      NSPNotificationRequest nr = new NSPNotificationRequest(Values.transactionId,
        Values.clientId, Values.destinationAddress, scv, Values.locale,
        Values.mediaType, Values.pageId);

      Gson gsonObj = new Gson();
      String jsonStr = gsonObj.toJson(nr);
      System.out.println(jsonStr);
  }