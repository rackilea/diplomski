import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.dropwizard.metrics.DropwizardMeterWrapper;
import org.apache.flink.metrics.Meter;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class Test {


    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env
                .readTextFile("/home/LizardKing/Documents/Power/Prova.csv")
                .map(new MyMapper())
                .writeAsCsv("/home/LizardKing/Results.csv");

        JobExecutionResult res = env.execute();
    }


    private static class MyMapper extends RichMapFunction<String, Object> {

        private transient Meter meter;

        @Override
        public void open(Configuration parameters) throws Exception {
            super.open(parameters);
            this.meter = getRuntimeContext()
                    .getMetricGroup()
                    .meter("myMeter", new DropwizardMeterWrapper(new com.codahale.metrics.Meter()));
        }

        @Override
        public Object map(String value) throws Exception {    
            this.meter.markEvent();
            return value;
        }
    }
}