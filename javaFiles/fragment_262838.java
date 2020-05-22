import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class ChartTest {
    public static void main(String[] args) {
        try {
            CPUUsageChart chart = CPUUsageChart.getInstance();
            for (int i = 0; i < 5; i++) {
                ObservableList<XYChart.Data<Number, Number>> cpuUsageData = FXCollections.observableArrayList();
                for (int j = 0; j < 10; j++) {
                    cpuUsageData.add(
                           new XYChart.Data<>(
                                   j / 10.0, 
                                   getSystemCpuLoad()
                           )
                    );
                    Thread.sleep(100);
                }
                chart.renderChart(cpuUsageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (MalformedObjectNameException | ReflectionException | InstanceNotFoundException e) {
            e.printStackTrace();
        } finally {
            Platform.exit();
        }
    }

    public static double getSystemCpuLoad() throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException {
        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "SystemCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        if (value == -1.0)      return Double.NaN;  // usually takes a couple of seconds before we get real values

        return ((int)(value * 1000) / 10.0);        // returns a percentage value with 1 decimal point precision
    }
}