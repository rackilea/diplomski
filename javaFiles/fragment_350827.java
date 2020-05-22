public class Q24000071 {

    public static void main(String[] args) {
             //the 'r' attribute, corresponding to 'ViewsHistoric' class, was missing
        String jsonExample = "{\"r\": ["
                + "{&#34;c&#34;:[{&#34;v&#34;:&#34;03/10/2013&#34;},{&#34;v&#34;:23},{&#34;v&#34;:112}]},"
                + "{&#34;c&#34;:[{&#34;v&#34;:&#34;04/10/2013&#34;},{&#34;v&#34;:14},{&#34;v&#34;:232}]},"
                + "{&#34;c&#34;:[{&#34;v&#34;:&#34;05/10/2013&#34;},{&#34;v&#34;:18},{&#34;v&#34;:145}]},"
                + "{&#34;c&#34;:[{&#34;v&#34;:&#34;06/10/2013&#34;},{&#34;v&#34;:22},{&#34;v&#34;:211}]},"
                + "{&#34;c&#34;:[{&#34;v&#34;:&#34;07/10/2013&#34;},{&#34;v&#34;:18},{&#34;v&#34;:198}]},"
                + "{&#34;c&#34;:[{&#34;v&#34;:&#34;08/10/2013&#34;},{&#34;v&#34;:15},{&#34;v&#34;:215}]}"
                + "]}";

        String unescape = StringEscapeUtils.unescapeHtml4(jsonExample);
        System.out.println(unescape);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ViewsHistoric viewHistoric = gson.fromJson(unescape,
                ViewsHistoric.class);
        System.out.println(gson.toJson(viewHistoric));
    }

    public static class ViewsHistoric {

        private List<Row> r;

        public List<Row> getR() {
            return r;
        }

        public ViewsHistoric() {
        }
    }

    public static class Row {

        // Triplet is an array in the original JSON
            // of three elements, but an array.
        private Triplet[] c;

        public Triplet[] getC() {
            return c;
        }

        public Row() {
        }
    }

    public static class Triplet {

        private String v;

        public String getV() {
            return v;
        }

        public Triplet() {
        }
    }
}