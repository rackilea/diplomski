JSONPostProcessor jsonExtractor = new JSONPostProcessor();
jsonExtractor.setName("JSON Extractor");
jsonExtractor.setRefNames("foo");
jsonExtractor.setJsonPathExpressions("$.title");
jsonExtractor.setProperty(TestElement.TEST_CLASS, JSONPostProcessor.class.getName());
jsonExtractor.setProperty(TestElement.GUI_CLASS, JSONPostProcessorGui.class.getName());