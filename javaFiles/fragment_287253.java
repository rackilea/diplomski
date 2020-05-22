public String submitSearchCriteriaFile(MultipleSlideDataObject2 slideData) throws IOException
{
    System.out.println("Recieved slide series with serial number: " + slideData.getSerialNumber());

    // If there is no slide data then...
    if (slideData == null)
    {
        return "process_MainSearchResultFailed";
    }
    else
    {
        rankProducts(slideData);
    }

    return "process_MainSearchResult";
}