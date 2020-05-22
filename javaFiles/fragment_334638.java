//to put setting in the index   
             StringEntity settingEntity= new StringEntity(settings.toString(), ContentType.APPLICATION_JSON);
            int statuscode2 = client.getLowLevelClient().performRequest("PUT", "/" + indexName , Collections.<String, String>emptyMap(), settingEntity).getStatusLine().getStatusCode();

            if(200 == statuscode2) {
            }


            //to put mapping in the index
            StringEntity mappingEntity = new StringEntity(mapping.toString(), ContentType.APPLICATION_JSON);
            int statuscode3 = client.getLowLevelClient().performRequest("PUT", "/" + indexName + "/" + typeName + "/" + "_mapping", Collections.<String, String>emptyMap(), mappingEntity).getStatusLine().getStatusCode();

            if(200 == statuscode3) {
            }