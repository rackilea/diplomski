import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;


/**
 * Wrapping {@link Runnable} to use with the load methods of  {@link VisualizationUtils} 
 * allowing a chart to be populated asynchronously (e.g., via RPC.)
 * 
 *  This wrapper handles the process of deferred attachment of the chart via the 
 *  {@link #onAttach(DataTable, Options)} method.
 *  
 *  Chart data is set / updated by means of a {@link AsyncChartWriter} mutating the 
 *  passed {@link DataTable} and {@link Options} instances.
 *  
 *  {@link AsyncChartWriter} can be reassigned (via {@link #enqueueWriter(AsyncChartWriter)}) 
 *  in order to redraw the chart.
 * 
 * @param <T>   The concrete chart type.
 */
public abstract class AsyncChart<T extends CoreChart> implements Runnable {
    public interface AsyncChartWriter {
        void onWrite(DataTable data, Options options);
    }

    private enum State {
        NEW,
        LOADED,
        ATTACHED
    }

    private State state;
    private T chart;
    private AsyncChartWriter enqueuedWriter;

    public AsyncChart() {
        this.state = State.NEW;
    }

    public abstract T onAttach(DataTable data, Options options);

    /**
     * Enqueues a writer to populate or manipulate the chart. This will happen immediately 
     * if the visualization API is already loaded and will otherwise be deferred.
     * 
     * @param writer    The writer to enqueue.
     */
    public void enqueueWriter(AsyncChartWriter writer) {
        this.enqueuedWriter = writer;
        processWriter();
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     * 
     * Invoked when the visualization API has loaded.
     */
    @Override
    public void run() {
        this.state = State.LOADED;
        if (this.enqueuedWriter != null) {
            processWriter();
        }
    }

    private void processWriter() {
        if (this.state == State.LOADED || this.state == State.ATTACHED) {
            DataTable data = DataTable.create();
            Options options = CoreChart.createOptions();
            this.enqueuedWriter.onWrite(data, options);
            if (this.state == State.LOADED) {
                this.chart = onAttach(data, options); // Instantiate and attach.
                this.state = State.ATTACHED;
            } else {
                this.chart.draw(data, options); // Redraw already attached chart.
            }
            this.enqueuedWriter = null;
        }
        // If state = NEW do nothing until run() is invoked (and state has changed to LOADED.) 
    }
}