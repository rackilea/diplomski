...
if(qName.equalsIgnoreCase("meta") && (attributes.getValue("name") != null)){
                key = attributes.getValue("name");
                if((key != null) && (!key.contains("Unknown"))){
                    content = attributes.getValue("content");
                    if(key.contains("Content-Type")){
                        String tmp[] = attributes.getValue("content").replace(' ', '\0').split(";");
                        if(tmp.length > 1){
                            content = tmp[0];
                        }
                    }
                    entityList.put(key, content);
                }
            }
...