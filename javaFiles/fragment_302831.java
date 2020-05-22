KieServices kieServices = KieServices.Factory.get();
KieContainer kieContainer = kieServices.getKieClasspathContainer();
DMNRuntime dmnRuntime = KieRuntimeFactory.of(kieContainer.getKieBase()).get(DMNRuntime.class);
DMNModel dmnModel = dmnRuntime.getModel(namespace, modelName);
DMNContext context = dmnRuntime.newContext();
((DMNRuntimeImpl) dmnRuntime).setOption(new RuntimeTypeCheckOption(true));
DMNResult result = dmnRuntime.evaluateAll(dmnModel, context);