public class RendersnakeTest {

    public static void main(String[] args) throws IOException {
        List<PoolMetrics> poolMetricsList = new ArrayList<>();
        poolMetricsList.add(new PoolMetrics("A", "0", "0", "0", "0"));
        poolMetricsList.add(new PoolMetrics("A", "1", "1", "1", "1"));
        poolMetricsList.add(new PoolMetrics("A", "2", "2", "2", "2"));
        poolMetricsList.add(new PoolMetrics("A", "3", "3", "3", "3"));
        poolMetricsList.add(new PoolMetrics("A", "4", "4", "4", "4"));

        HtmlCanvas html = new HtmlCanvas();
        html.html().body().table().tr().th().content("PoolName").th().content("TotalSyncCount").th()
                .content("TotalAsyncCount").th().content("SyncNinetyFivePercentile").th()
                .content("AsyncNinetyFivePercentile")._tr();

        // add the rows
        for (PoolMetrics pool : poolMetricsList) {
            html.tr()
                    .td(class_("city-table")).content(pool.getPoolName())
                    .td().content(pool.getTotalAsyncCount())
                    .td().content(pool.getTotalSyncCount())
                    .td().content(pool.getSyncNinetyFivePercentile())
                    .td().content(pool.getAsyncNinetyFivePercentile())
                ._tr();
        }

        // close the table
        html._table()._body()._html();

        // write the file
        final String rendered = html.toHtml();
        final File output = new File("c:/output.html");
        Files.write(output.toPath(), rendered.getBytes("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING);
    }

}

class PoolMetrics {

    private String poolName;
    private String totalSyncCount;
    private String totalAsyncCount;
    private String syncNinetyFivePercentile;
    private String asyncNinetyFivePercentile;

    public PoolMetrics(String poolName, String totalSyncCount, String totalAsyncCount, String syncNinetyFivePercentile, String asyncNinetyFivePercentile) {
        this.poolName = poolName;
        this.totalSyncCount = totalSyncCount;
        this.totalAsyncCount = totalAsyncCount;
        this.syncNinetyFivePercentile = syncNinetyFivePercentile;
        this.asyncNinetyFivePercentile = asyncNinetyFivePercentile;
    }

    public String getPoolName() {
        return poolName;
    }

    public String getTotalSyncCount() {
        return totalSyncCount;
    }

    public String getTotalAsyncCount() {
        return totalAsyncCount;
    }

    public String getSyncNinetyFivePercentile() {
        return syncNinetyFivePercentile;
    }

    public String getAsyncNinetyFivePercentile() {
        return asyncNinetyFivePercentile;
    }
}