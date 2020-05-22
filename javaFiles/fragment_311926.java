InfoController obj = new InfoController();

            //Fetching the values of 'appName' & 'appKey' sent from 'info' DB
            HashMap<String, String> appKeys = obj.fetchData();

            storedAppkey = appKeys.get(appName);

            //Handling the case of mismatch
            if (storedAppkey == null || storedApikey.compareTo(appKey)!=0)
            {//Then the response and further processing that I need to do.