Iterator<String> pIt = parent.fieldNames();
    while(pIt.hasNext())
    {
        String tempkey = pIt.next();

        if(child.path(tempkey) != null)
        {
            merged.put(tempkey,child.path(tempkey));

        }
        else{
                merged.put(tempkey,parent.path(tempkey) );
        }

    }

    try {
        String jsonString = mapper.writeValueAsString(merged);
        System.out.println(jsonString);
    } catch (JsonProcessingException e) {...}