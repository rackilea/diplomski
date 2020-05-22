public class StockDownloader {
    public static final int DATE = 0;
    public static final int OPEN = 1;
    public static final int HIGH = 2;
    public static final int LOW = 3;
    public static final int CLOSE = 4;
    public static final int VOLUME = 6;
    public static final int ADJCLOSE = 5;

    private ArrayList<GregorianCalendar> dates;
    private ArrayList<Double> opens;
    private ArrayList<Double> highs;
    private ArrayList<Double> lows;
    private ArrayList<Double> closes;
    private ArrayList<Integer> volumes;
    private ArrayList<Double> adjCloses;

    private String finalCrumb;

    public StockDownloader(String symbol) {
        dates = new ArrayList<GregorianCalendar>();
        opens = new ArrayList<Double>();
        highs = new ArrayList<Double>();
        lows = new ArrayList<Double>();
        closes = new ArrayList<Double>();
        volumes = new ArrayList<Integer>();
        adjCloses = new ArrayList<Double>();

        try {

            // Hit the below URL to get the cookies and the crumb value to access the finance API
            String mainURL = "https://uk.finance.yahoo.com/quote/"+symbol+"/history";
            Map<String, List<String>> setCookies = setCookies(mainURL);
            // https://query1.finance.yahoo.com/v7/finance/download/IBM?period1=1467352800&period2=1498888800&interval=1d&events=history&crumb=2WsiR.p1KtI

            // will need to append the crumb in the end to the below URL to have the actual crumb rather than the hardcoded one
            String url = "https://query1.finance.yahoo.com/v7/finance/download/" + symbol
                    + "?period1=1467352800&period2=1498888800&interval=1d&events=history&crumb=" + finalCrumb;
            URL yhoofin = new URL(url);
            URLConnection data = yhoofin.openConnection();

            // get the list of Set-Cookie cookies from response headers
            List<String> cookies = setCookies.get("Set-Cookie");
            if (cookies != null) {
                for (String c : cookies)
                    data.setRequestProperty("Cookie", c);
            }
            Scanner input = new Scanner(data.getInputStream());
            if (input.hasNext())// skip line...it's just the header
                input.nextLine();

            // start reading data
            while (input.hasNextLine()) {
                String line = input.nextLine();
                // TODO- connec tdata to the correct ArrayList
                System.out.println(line);
            }
            input.close();
        }

        catch (Exception e) {
            System.err.println(e);
        }

    }

    // This method extracts the crumb and is being called from setCookies() method
    private String searchCrumb(URLConnection con) throws IOException {
        String crumb = null;
        InputStream inStream = con.getInputStream();
        InputStreamReader irdr = new InputStreamReader(inStream);
        BufferedReader rsv = new BufferedReader(irdr);

        Pattern crumbPattern = Pattern.compile(".*\"CrumbStore\":\\{\"crumb\":\"([^\"]+)\"\\}.*");

        String line = null;
        while (crumb == null && (line = rsv.readLine()) != null) {
            Matcher matcher = crumbPattern.matcher(line);
            if (matcher.matches())
                crumb = matcher.group(1);
        }
        rsv.close();
        System.out.println("Crumb is : "+crumb);
        return crumb;
    }


    // This method extracts the cookies from response headers and passes the same con object to searchCrumb()
    // method to extract the crumb and set the crumb value in finalCrumb global variable
    private Map<String, List<String>> setCookies(String mainUrl) throws IOException {
        // "https://finance.yahoo.com/quote/SPY";
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        URL url = new URL(mainUrl);
        URLConnection con = url.openConnection();
        finalCrumb = searchCrumb(con);
        for (Map.Entry<String, List<String>> entry : con.getHeaderFields().entrySet()) {
            if (entry.getKey() == null || !entry.getKey().equals("Set-Cookie"))
                continue;
            for (String s : entry.getValue()) {
                map.put(entry.getKey(), entry.getValue());
                System.out.println(map);
            }
        }

        return map;

    }

    public ArrayList<GregorianCalendar> getDates() {
        return dates;
    }

}