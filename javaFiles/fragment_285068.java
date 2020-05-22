try{
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
        catch (IOException e){
            e.printStackTrace();
        }