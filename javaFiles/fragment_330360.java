// JMeter Test Plan, basically JOrphan HashTree
HashTree testPlanTree = new HashTree();

// Create Header Manager
HeaderManager manager = new HeaderManager();
manager.add(new Header("Content-Type", "application/json"));
manager.setName(JMeterUtils.getResString("header_manager_title")); // $NON-NLS-1$
manager.setProperty(TestElement.TEST_CLASS, HeaderManager.class.getName());
manager.setProperty(TestElement.GUI_CLASS, HeaderPanel.class.getName());

// HTTP Sampler 
HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
httpSamplerProxy.setDomain("localhost");
httpSamplerProxy.setPort(8090);
httpSamplerProxy.setPath("/");
httpSamplerProxy.setMethod("POST");
httpSamplerProxy.setName("HTTP Request");
httpSamplerProxy.addEncodedArgument("Body Data", "{\"1\":\"2\"}", "");
httpSamplerProxy.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
httpSamplerProxy.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());


// Loop Controller
LoopController loopController = new LoopController();
loopController.setLoops(1);
loopController.setFirst(true);
loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
loopController.initialize();

// Thread Group
ThreadGroup threadGroup = new ThreadGroup();
threadGroup.setName("Example Thread Group");
threadGroup.setNumThreads(1);
threadGroup.setRampUp(1);
threadGroup.setSamplerController(loopController);
threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

// Test Plan
TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

// HTTP Request Sampler and Header Manager
HashTree requestHashTree = new HashTree();
requestHashTree.add(httpSamplerProxy, manager);

// Construct Test Plan from previously initialized elements
testPlanTree.add(testPlan);
HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
threadGroupHashTree.add(requestHashTree);