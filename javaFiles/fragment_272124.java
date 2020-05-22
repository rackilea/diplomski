import java.util.ArrayList;
  import java.util.List;
  import com.google.gson.Gson;
  import com.xxx.nsp.constants.Values;
  import com.xxx.nsp.dto.Address;
  import com.xxx.nsp.dto.SendCVConfirmationNotification;
  import com.xxx.nsp.dto.VisibilityInfo;
  import com.xxx.nsp.dto.VisibilityType;
  import com.xxx.nsp.json.NSPNotificationRequest;
  public class MainClass {
      public static void main(String[] args) {  

          Address addr = new Address(Values.addressType, Values.addressLine1, 
            Values.addressLine2, Values.addressLine3, Values.politicalDivision,
            Values.city, Values.state, Values.zipcode, null, Values.phoneNumber);

          List<String> accountNumbers = new ArrayList<>();
          accountNumbers.add("1233");
          accountNumbers.add("2234");

          List<VisibilityInfo> visibilityInfo = new ArrayList<>();        
          visibilityInfo.add(new VisibilityInfo(VisibilityType.THIRD_PARTY,
            accountNumbers, addr));  

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
  }