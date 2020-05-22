// create a flashmap
FlashMap flashMap = new FlashMap();

// store the message
flashMap.put("ERROR_MESSAGE", "this is the message");

// create a flashmapMapManger with `request`
FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);

// save the flash map data in session with falshMapManager
flashMapManager.saveOutputFlashMap(flashMap, request, response);