@DirectMethod
public PartialResult<ResourceData> getM2Mresources(int start, int limit) {
        ResourceData[] m2mResources = ...
    //...
        return new PartialResult<ResourceData>(Arrays.asList(m2mResources), 
    m2mResources.length);
}