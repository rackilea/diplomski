public XMLInputSource resolveEntity(XMLResourceIdentifier resourceIdentifier)
    throws IOException
{
    if(resourceIdentifier.getExpandedSystemId() != null)
    {
        return new XMLInputSource(resourceIdentifier.getPublicId(),
            resourceIdentifier.getLiteralSystemId(),
            resourceIdentifier.getBaseSystemId(),
            new FileReader(getFile(resourceIdentifier.getExpandedSystemId())),
            "UTF-8");
    }
    else if((resourceIdentifier.getBaseSystemId() != null) &&
        (resourceIdentifier.getNamespace() == null))
    {
        return new XMLInputSource(resourceIdentifier.getPublicId(),
            resourceIdentifier.getLiteralSystemId(),
            resourceIdentifier.getBaseSystemId(),
            new FileReader(getFile(resourceIdentifier.getBaseSystemId())),
            "UTF-8");
    }
    else
    {
        return super.resolveEntity(resourceIdentifier);
    }
}

private File getFile(String urlString) throws MalformedURLException
{
    URL url = new URL(urlString);
    return new File(url.toURI());
}