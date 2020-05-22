import play.Application;
import play.GlobalSettings;
import play.Logger;

import controllers.Utils;
import com.Constants;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        Logger.info("Application has started");
        Constants.data1 = Utils.getMerchantToBrMapping(Utils.getMerchantName());
        Constants.data2 = Utils.getBrToMerchantMapping(Utils.getMerchantName());
        Logger.info("Loaded the Merchant To BR Map");
    }
}