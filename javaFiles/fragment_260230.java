@Override
public **LCBOStore** read() throws **Exception**, UnexpectedInputException, ParseException, NonTransientResourceException {
    Class<LCBOStore> classType = LCBOStore.class;

    return createCSVReader(classType, currentCSVFilePath, inventoryTrackerProperties.getLCBOFilPropertiess().getStores());
}