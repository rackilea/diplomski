import java.util.*;
import java.lang.*;

class Rextester
{  
    public static void main(String args[])
    {
        String str = new String("kyc_CWaccountOperatorName|DANIYAL,kyc_cnic_ind|9110129505705,kyc_fatherName|Abujan,kyc_motherMaidenName|MOTHER,kyc_CWmobileNumber|03312551746,kyc_CWdateOfBirth|20/02/1993,kyc_cnicDateOfExpiry|2027-02-20,kyc_CWplaceOfBirth|KHI,kyc_mailAddHouseFlat No|Dha,kyc_city|Abbottabad");
        String[] ar = str.replace("|","=").split(",",0);
        for(String s : ar)
            System.out.println(s);
    }
}