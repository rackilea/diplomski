//Convert Java Object to Json               
            JsonElement element = gson.toJsonTree(showCoustomerList, new TypeToken<List<Customers>>() {}.getType());
            JsonArray jsonArray = element.getAsJsonArray();
            String listData=jsonArray.toString();               
            //Return Json in the format required by jTable plugin
            listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";            
            response.getWriter().print(listData);