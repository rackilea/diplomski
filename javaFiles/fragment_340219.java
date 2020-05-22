public class PriceVolumeChart2 extends ApplicationFrame{


final static String filename = "A.txt";
static TimeSeries t1 = new TimeSeries("49-day moving average");

/**
 * Default constructor
 */
public PriceVolumeChart2(String title)
{
    super(title);
    JPanel panel = createDemoPanel();
    panel.setPreferredSize(new Dimension(500, 270));
    setContentPane(panel);
}


//create price dataset
//hard-coded here
private static OHLCDataset createPriceDataset(String filename)
{
    //the following data is taken from http://finance.yahoo.com/
    //for demo purposes...


    OHLCSeries s1 = new OHLCSeries(filename);

    try {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String inputLine;
        in.readLine();
        while ((inputLine = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(inputLine, ",");
            Date date       = df.parse( st.nextToken() );
            double open     = Double.parseDouble( st.nextToken() );
            double high     = Double.parseDouble( st.nextToken() );
            double low      = Double.parseDouble( st.nextToken() );
            double close    = Double.parseDouble( st.nextToken() );
            double volume   = Double.parseDouble( st.nextToken() );
            //double adjClose = Double.parseDouble( st.nextToken() );
            s1.add(new Day(date), open, high, low, close);
            t1.add(new Day(date), close);
        }
        in.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }



    OHLCSeriesCollection dataset = new OHLCSeriesCollection();
    dataset.addSeries(s1);

    return dataset;
}


//create volume dataset
private static IntervalXYDataset createVolumeDataset(String filename)
{
    //create dataset 2...
    TimeSeries s1 = new TimeSeries("Volume");

    try {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String inputLine;
        in.readLine();
        while ((inputLine = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(inputLine, ",");
            Date date = df.parse( st.nextToken() );
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            double volume   = Double.parseDouble( st.nextToken() );
            //double adjClose = Double.parseDouble( st.nextToken() );
            s1.add(new Day(date), volume);
        }
        in.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }



    return new TimeSeriesCollection(s1);
}


private static JFreeChart createCombinedChart()
{
    OHLCDataset data1 = createPriceDataset(filename);

    XYItemRenderer renderer1 = new HighLowRenderer();
    renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator(StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT, new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
    renderer1.setSeriesPaint(0, Color.blue);
    DateAxis domainAxis = new DateAxis("Date");
    NumberAxis rangeAxis = new NumberAxis("Price");
    rangeAxis.setNumberFormatOverride(new DecimalFormat("$0.00"));
    rangeAxis.setAutoRange(true);
    rangeAxis.setAutoRangeIncludesZero(false);
    XYPlot plot1 = new XYPlot(data1, domainAxis, rangeAxis, renderer1);
    plot1.setBackgroundPaint(Color.lightGray);
    plot1.setDomainGridlinePaint(Color.white);
    plot1.setRangeGridlinePaint(Color.white);
    plot1.setRangePannable(true);

    //Overlay the Long-Term Trend Indicator
    TimeSeries dataset3 = MovingAverage.createMovingAverage(t1, "LT", 49, 49);
    TimeSeriesCollection collection = new TimeSeriesCollection();
    collection.addSeries(dataset3);
    plot1.setDataset(1, collection);
    plot1.setRenderer(1, new StandardXYItemRenderer());

    //add a second dataset (volume) and renderer
    IntervalXYDataset data2 = createVolumeDataset(filename);
    XYBarRenderer renderer2 = new XYBarRenderer();
    renderer2.setDrawBarOutline(false);
    renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator(StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT, new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.00")));
    renderer2.setSeriesPaint(0, Color.red);

    XYPlot plot2 = new XYPlot(data2, null, new NumberAxis("Volume"), renderer2);
    plot2.setBackgroundPaint(Color.lightGray);
    plot2.setDomainGridlinePaint(Color.white);
    plot2.setRangeGridlinePaint(Color.white);

    //middle pane oscillator
    TimeSeries threeMA = MovingAverage.createMovingAverage(t1, "SL1", 3, 3);
    TimeSeries tenMA = MovingAverage.createMovingAverage(t1, "SL2", 10, 10);

    List<TimeSeriesDataItem> threeItemsList = new ArrayList<TimeSeriesDataItem>();
    List<TimeSeriesDataItem> tenItemsList = new ArrayList<TimeSeriesDataItem>();
    threeItemsList = threeMA.getItems();
    tenItemsList = tenMA.getItems();

    for (TimeSeriesDataItem item: threeItemsList)
    {
        System.out.println("three" + item.getValue().doubleValue() + " " + item.getPeriod().toString());
    }

    for (TimeSeriesDataItem item: tenItemsList)
    {
        System.out.println("ten" + item.getValue().doubleValue() + " " + item.getPeriod().toString());
    }

    TimeSeries slDataset = new TimeSeries("SL");
    int i = 0;
    //List<TimeSeriesDataItem> slItemsList = new ArrayList<TimeSeriesDataItem>();
    TimeSeriesDataItem myItem;
    Day threeDate;

    for (TimeSeriesDataItem item: threeItemsList)
    {
        //RegularTimePeriod variable = item.getPeriod();
        if (item.getPeriod().compareTo(tenItemsList.get(0).getPeriod()) < 0)
        {
            continue;
        }
        else
        {
            double result = item.getValue().doubleValue() - tenItemsList.get(i).getValue().doubleValue();
            Day currentDay = (Day)item.getPeriod();
            myItem = new TimeSeriesDataItem(currentDay, result);
            slDataset.add(myItem);

            //slItemsList.add(myItem);
            i++;
        }


    }

    System.out.println("slDataset count : " + slDataset.getItemCount());



    TimeSeriesCollection collectionSL = new TimeSeriesCollection();
    collectionSL.addSeries(slDataset);

    XYPlot plot3 = new XYPlot(collectionSL, new DateAxis("Date"), new NumberAxis("Value"), new StandardXYItemRenderer());
    plot3.setBackgroundPaint(Color.lightGray);
    plot3.setDomainGridlinePaint(Color.white);
    plot3.setRangeGridlinePaint(Color.white);
    plot3.setRangePannable(true);
    plot3.setDomainPannable(true);



    CombinedDomainXYPlot cplot = new CombinedDomainXYPlot(domainAxis);
    cplot.add(plot1, 3);
    cplot.add(plot3, 2);
    cplot.add(plot2, 2);
    cplot.setGap(8.0);
    cplot.setDomainGridlinePaint(Color.white);
    cplot.setDomainGridlinesVisible(true);
    cplot.setDomainPannable(true);


    //return the new combined chart
    JFreeChart chart = new JFreeChart("Sun Microsystems (SUNW)", JFreeChart.DEFAULT_TITLE_FONT, cplot, false);


    ChartUtilities.applyCurrentTheme(chart);
    renderer2.setShadowVisible(false);
    renderer2.setBarPainter(new StandardXYBarPainter());

    return chart;
}


//create a panel
public static JPanel createDemoPanel()
{
    JFreeChart chart = createCombinedChart();
    ChartPanel panel = new ChartPanel(chart);
    panel.setMouseWheelEnabled(true);

    return panel;
}

public static void main(String[] args) {
    // TODO code application logic here
    PriceVolumeChart2 demo = new PriceVolumeChart2("JFreeChart: CombinedXYPlotDemo1.java (base)");
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
}