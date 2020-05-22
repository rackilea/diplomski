package controllers;


import play.Logger;
import play.mvc.*;



public class Application extends Controller {

    private static final Logger.ALogger CustomLogger = Logger.of("custom");

    public Result index() {



        String toNormal = "this goes normal way";
        String tolevelInfo = "this goes to info";
        String toCustom = "this goes to custom";

        Logger.info(tolevelInfo);



        Logger.error(toNormal);
        Logger.debug(toNormal);
        Logger.warn(toNormal);

        CustomLogger.info(toCustom);



        return ok("Take a look of your logs files");
    }

}