while ((line = reader.readLine()) != null) 
        {
            System.out.println(line);
            JSONArray jsonArr = new JSONArray(line);
            JSONObject obj = jsonArr .getJSONObject(0);
            String abstracts = obj.getString("abstractNote");
            System.out.println(abstracts);
            article.SetAbstracts(abstracts);
            DatabaseHandler.GetInstance().UpdateArticle(article);

        }