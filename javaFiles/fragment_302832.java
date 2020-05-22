KieContainer kieContainer = KieHelper.getKieContainer(ks.newReleaseId("org.kie", "dmn-test-" + UUID.randomUUID(), "1.2"),
                                                      ks.getResources().newFileSystemResource(new File(dmnFile)));
DMNRuntime dmnRuntime = KieRuntimeFactory.of(kieContainer.getKieBase()).get(DMNRuntime.class);
((DMNRuntimeImpl) dmnRuntime).setOption(new RuntimeTypeCheckOption(true));
DMNModel dmnModel = dmnRuntime.getModel(namespace, modelName);
DMNContext context = dmnRuntime.newContext();
DMNResult result = dmnRuntime.evaluateAll(dmnModel, context);
System.out.println(result);