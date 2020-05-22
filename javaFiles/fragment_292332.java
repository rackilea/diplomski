WebView  web = new WebView();
WebEngine webEngine = web.getEngine();
webEngine.loadContent
(
    "<b>AlgorithmType:</b> " + paggingTest.getAlgorithmType()
    + "<br/><b>Memory Pages:</b> " + paggingTest.getMemoryPages()
    + "<br/><b>Program Pages:</b> " + paggingTest.getProgramPages()
    + "<br/><b>Sample Count:</b> " + paggingTest.getSampleCount()
    + "<br/><b>Distribution Type:</b> " + paggingTest.getDistributionType()
);

Tooltip  tip = new Tooltip();
tip.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
tip.setGraphic(web);