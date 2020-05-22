import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardService {

    public CardDetailsDTO serviceCall(List<?> mapDetails) {

        CardDetailsDTO cardDetailsDTO = new CardDetailsDTO();
        final Map<String, String> debitCardDetailsMap = new HashMap<String, String>();
        final Map<String, String> creditCardDetailsMap = new HashMap<String, String>();


        /*code implementation */
        debitCardDetailsMap.put("type", "VISA");
        debitCardDetailsMap.put("bank", "BofA");
        debitCardDetailsMap.put("rank", "2");

        cardDetailsDTO.setDebitCardDetails(debitCardDetailsMap);

        creditCardDetailsMap.put("type", "VISA");
        creditCardDetailsMap.put("number","23345");
        creditCardDetailsMap.put("bank", "citi");

        cardDetailsDTO.setCreditCardDetails(creditCardDetailsMap);

        return cardDetailsDTO;
    }
}