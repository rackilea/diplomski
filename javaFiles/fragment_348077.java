import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.extractor.json.jsonpath.JSONPostProcessor;
import org.apache.jmeter.extractor.json.jsonpath.gui.JSONPostProcessorGui;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.FileOutputStream;

public class JMeterFromJava {

    public static void main(String[] args) throws Exception {

        StandardJMeterEngine jm = new StandardJMeterEngine();

        String jmeterHome = "/path/to/your/JMeter/installation";


        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(jmeterHome + "/bin/jmeter.properties");
        JMeterUtils.initLocale();


        HashTree testPlanTree = new HashTree();


        HTTPSamplerProxy jsonPlaceHolderSampler = new HTTPSamplerProxy();
        jsonPlaceHolderSampler.setDomain("https://jsonplaceholder.typicode.com/posts/1");
        jsonPlaceHolderSampler.setPort(80);
        jsonPlaceHolderSampler.setPath("/");
        jsonPlaceHolderSampler.setMethod("GET");
        jsonPlaceHolderSampler.setName("HTTP Request");
        jsonPlaceHolderSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        jsonPlaceHolderSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());

        JSONPostProcessor jsonExtractor = new JSONPostProcessor();
        jsonExtractor.setName("JSON Extractor");
        jsonExtractor.setRefNames("foo");
        jsonExtractor.setJsonPathExpressions("$.title");
        jsonExtractor.setProperty(TestElement.TEST_CLASS, JSONPostProcessor.class.getName());
        jsonExtractor.setProperty(TestElement.GUI_CLASS, JSONPostProcessorGui.class.getName());


        LoopController loopController = new LoopController();
        loopController.setLoops(1);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Example Thread Group");
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

        TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

        HashTree blazeMeterSamplerTree = new HashTree();
        blazeMeterSamplerTree.add(jsonPlaceHolderSampler, jsonExtractor);


        testPlanTree.add(testPlan);
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        threadGroupHashTree.add(blazeMeterSamplerTree);

        SaveService.saveTree(testPlanTree, new FileOutputStream(jmeterHome + "/bin/test.jmx"));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        String logFile = jmeterHome + "/bin/test.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        jm.configure(testPlanTree);

        jm.run();
    }
}