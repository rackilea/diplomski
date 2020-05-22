Iterator<String> keys= object.keys();
while (keys.hasNext()) 
{
        String keyValue = (String)keys.next();
        String valueString = object.getString(keyValue);
}