import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Transfer;

public class StripeExample
{
    public static void main(String[] args)
    {
        String key = "sk_test_*********";
        try
        {
            // Set your secret key: remember to change this to your live secret
            // key in production
            // See your keys here https://dashboard.stripe.com/account/apikeys
            Stripe.apiKey = key;

            Map<String, Object> defaultAccountParams = new HashMap<String, Object>();

            Map<String, Object> externalAccount = new HashMap<String, Object>();

            externalAccount.put("country", "US");
            externalAccount.put("routing_number", "110000000");
            externalAccount.put("account_number", "000123456789");
            externalAccount.put("account_holder_name", "Test Holder");
            externalAccount.put("account_holder_type", "individual");
            externalAccount.put("object", "bank_account");

            defaultAccountParams.put("external_account", externalAccount);
            defaultAccountParams.put("email", getUniqueEmail());

            Account destination = Account.create(defaultAccountParams);

            Map<String, Object> transferParams = new HashMap<String, Object>();

            transferParams.put("amount", 1000);
            transferParams.put("currency", "usd");
            transferParams.put("destination", destination.getId());

            Transfer transfer = Transfer.create(transferParams);
        }
        catch (StripeException e)
        {
            e.printStackTrace();
        }
    }

    static String getUniqueEmail()
    {
        return String.format("test+bindings-%s@stripe.com", UUID.randomUUID().toString().substring(24));
    }
}