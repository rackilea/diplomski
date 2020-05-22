try {
     // get chartApp instance, blocking until it is available.
     CPUUsageChart chartApp = CPUUsageChart.getInstance();
     // call render chart as many times as you want
     chartApp.renderChart(cpuUsageData);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
} finally {
     // note your program should only ever exit the platform once.
     Platform.exit(); 
}