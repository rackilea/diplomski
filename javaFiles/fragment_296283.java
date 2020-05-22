requests.add(new Request().setUpdateDimensionProperties(
                new UpdateDimensionPropertiesRequest()
                        .setRange(
                                new DimensionRange()
                                        .setSheetId(sheetID)
                                        .setDimension("COLUMNS")
                                        .setStartIndex(0)
                                        .setEndIndex(1)
                        )
                        .setProperties(
                                new DimensionProperties()
                                        .setPixelSize(400))
                        .setFields("pixelSize")));