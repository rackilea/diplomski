try{
        StringBuilder sb = new StringBuilder();
        getResponseString = "";
        while((getResponseString = reader.readLine()) != null){
            Log.d("Response ==== ", getResponseString);
            sb.append(getResponseString);
        }
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        if(reader != null){
            try{
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

return sb.toString();