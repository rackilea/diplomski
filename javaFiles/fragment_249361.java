public static AndroidTourController getController(
    TourControllerParameters paramTourControllerParameters,
    TourSequencer paramTourSequencer)
{
    CustomBlock customBlock = (CustomBlock)paramTourControllerParameters;
    return new EnableTableController(customBlock, paramTourSequencer);
}