if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = bufferedReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            JSONObject jsonObject = XML.toJSONObject(responseStrBuilder.toString());
            System.out.println(jsonObject);

            org.bson.Document jsonDocument = org.bson.Document.parse(jsonObject.toString());
            mongoCollection.insertOne(jsonDocument);
            System.out.println("Collection inserted successfully");
        }