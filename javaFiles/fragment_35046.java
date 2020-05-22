public class PieChartCustomizer implements JRChartCustomizer {

    private static final String LOCALE_PROPERTY = "locale"; // the same name as at jrxml file
    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

    @Override
    public void customize(JFreeChart chart, JRChart jasperChart) {
        PiePlot pieChart = (PiePlot) chart.getPlot();
        JRPropertiesMap map = jasperChart.getPropertiesMap();

        Locale locale = DEFAULT_LOCALE; // this is default Locale if property was not set
        if (map != null && !map.isEmpty()) {
            if (!isNullOrEmpty(map.getProperty(LOCALE_PROPERTY))) {
                locale = Locale.forLanguageTag(map.getProperty(LOCALE_PROPERTY).replace("_", "-")); // here we have Locale passed via property 'locale'. Replacement applied: en_GB -> en-GB, for example
            }
        }

        // some actions 
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}