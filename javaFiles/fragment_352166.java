Map<String, Number> unitNameValueMap = new HashMap<String, Number>();

unitNameValueMap.put("Unit 1", defined1);
unitNameValueMap.put("Unit 2", defined2);

Number factor(String unitName)
{
    Number result = unitNameValueMap.get(unitName);

    if(result == null)
    {
        throw new Exception("Unknown unit");
    }

    return result;
}