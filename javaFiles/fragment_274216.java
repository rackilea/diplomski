public class Utils {
    static String getLocationResultTitle(Context context, List<Location> locations) {
        if (AngeboteActivity.DataHolder.hasData()) {
            //if hasData do your stuff what you want
            String numLocationsReported = "Text1";
            return numLocationsReported + " \r\n \r\n :) \r\n \r\n" + DateFormat.getDateTimeInstance().format(new Date());

        } else {
            String numLocationsReported = "Text2";
            return numLocationsReported + " \r\n \r\n :( \r\n \r\n" + DateFormat.getDateTimeInstance().format(new Date());

        }
    }
}