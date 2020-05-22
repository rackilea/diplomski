import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IAxis;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries.SeriesType;

    /**
    * An example for area chart.
    */
    public class AreaChartExample {

        private static final double[] ySeries1 = { 0.1, 0.38, 0.71, 0.92, 1.0 };

        private static final double[] ySeries2 = { 1.2, 3.53, 3.1, 0.1, 0.5 };

        /* Used to remember location point of mouse down */
        private static double startX;
        private static double startY;

        private static int startXPos;
        private static int startYPos;

        private static int currentX;
        private static int currentY;

        private static boolean drag = false;

        /**
        * The main method.
        * 
        * @param args
        *            the arguments
        */
        public static void main(String[] args) {
            Display display = new Display();
            Shell shell = new Shell(display);
            shell.setText("Area Chart");
            shell.setSize(500, 400);
            shell.setLayout(new FillLayout());

            createChart(shell);

            shell.open();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
            display.dispose();
        }

        /**
        * create the chart.
        * 
        * @param parent
        *            The parent composite
        * @return The created chart
        */
        static public Chart createChart(Composite parent) {

            // create a chart
            final Chart chart = new Chart(parent, SWT.NONE);

            // set titles
            chart.getTitle().setText("Area Chart");

            // create line series
            ILineSeries lineSeries1 = (ILineSeries) chart.getSeriesSet()
                    .createSeries(SeriesType.LINE, "line series 1");
            lineSeries1.setYSeries(ySeries1);
            lineSeries1.setLineColor(Display.getDefault().getSystemColor(
                    SWT.COLOR_RED));
            lineSeries1.enableArea(true);

            ILineSeries lineSeries2 = (ILineSeries) chart.getSeriesSet()
                    .createSeries(SeriesType.LINE, "line series 2");
            lineSeries2.setYSeries(ySeries2);
            lineSeries2.enableArea(true);

            // adjust the axis range
            chart.getAxisSet().adjustRange();

            /* Get the plot area and add the mouse listeners */
            final Composite plotArea = chart.getPlotArea();

            plotArea.addListener(SWT.MouseDown, new Listener() {

                @Override
                public void handleEvent(Event event) {
                    IAxis xAxis = chart.getAxisSet().getXAxis(0);
                    IAxis yAxis = chart.getAxisSet().getYAxis(0);

                    startX = xAxis.getDataCoordinate(event.x);
                    startY = yAxis.getDataCoordinate(event.y);

                    startXPos = event.x;
                    startYPos = event.y;

                    drag = true;
                }
            });

            plotArea.addListener(SWT.MouseUp, new Listener() {

                @Override
                public void handleEvent(Event event) {
                    IAxis xAxis = chart.getAxisSet().getXAxis(0);
                    IAxis yAxis = chart.getAxisSet().getYAxis(0);

                    double endX = xAxis.getDataCoordinate(event.x);
                    double endY = yAxis.getDataCoordinate(event.y);

                    System.out.println(startX + " " + endX);
                    System.out.println(startY + " " + endY);

                    drag = false;

                    plotArea.redraw();
                }
            });

            plotArea.addListener(SWT.MouseMove, new Listener() {

                @Override
                public void handleEvent(Event event) {
                    if(drag)
                    {
                        currentX = event.x;
                        currentY = event.y;

                        plotArea.redraw();
                    }
                }
            });

            plotArea.addListener(SWT.Paint, new Listener() {

                @Override
                public void handleEvent(Event event) {
                    if(drag)
                    {
                        GC gc = event.gc;

                        gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
                        gc.setAlpha(128);

                        int minX = Math.min(startXPos, currentX);
                        int minY = Math.min(startYPos, currentY);

                        int maxX = Math.max(startXPos, currentX);
                        int maxY = Math.max(startYPos, currentY);

                        int width = maxX - minX;
                        int height = maxY - minY;

                        gc.fillRectangle(minX, minY, width, height);
                    }
                }
            });

            return chart;
        }
    }