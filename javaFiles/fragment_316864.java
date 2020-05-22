@Spy
LoadJsonData loadJsonData;

// this wil tell Mockito to return jsonStr when getJsonData() is invoked on the spy
doReturn(jsonStr).when(loadJsonData.getJsonData());

// this will invoke the actual implementation
assertEquals(loadJsonData.getChartTypeJS(), "javascript:setChartSeriesType(%d);");