String                         firstKey  = "name1";
Map<String,Map<String,String>> recordset = new HashMap<String,HashMap<String,String>>();
Map<String,String>             record    = null;
String                         key       = null;

while (outerScan.hasNextLine()){
    Scanner innerScan = new Scanner(outerScan.nextLine());
    try{
        innerScan.useDelimiter(":");
        String name = innerScan.next();
        String value = innerScan.next();
        String rName = name.trim();
        String rValue = value.replaceAll("[^\\w]", "");
        if (firstKey.equals(name))
        {
            if (record != null) recordset.put(key,record);
            record = new HashMap<String,String>();
            key    = rValue;
        }
        if (record == null) throw new RuntimeException(String.format("First line was not '%s'",firstKey));
        record.put(rName,rValue);
    }
    catch(Exception e){   
        /* DO NOT IGNORE EXCEPTIONS */
    }
    if (record != null) recordset.put(key,record);
}