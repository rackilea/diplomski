import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;

import static org.apache.jmeter.JMeter.JMETER_REPORT_OUTPUT_DIR_PROPERTY;

public class RunJMeterTest {

    public static void main(String[] args) throws Exception {
        StandardJMeterEngine jmeter = new StandardJMeterEngine();
        JMeterUtils.loadJMeterProperties("/path/to/your/jmeter/bin/jmeter.properties");
        JMeterUtils.setJMeterHome("/path/to/your/jmeter");
        JMeterUtils.initLocale();
        SaveService.loadProperties();
        HashTree testPlanTree = SaveService.loadTree(new File("/path/to/your/jmeter/bin/test.jmx"));
        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }
        String logFile = "/path/to/your/jmeter/bin/result.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);
        jmeter.configure(testPlanTree);
        jmeter.run();
        JMeterUtils.setProperty(JMETER_REPORT_OUTPUT_DIR_PROPERTY, "/path/to/dashboard");
        ReportGenerator generator = new ReportGenerator(logFile, null);
        generator.generate();
    }
}