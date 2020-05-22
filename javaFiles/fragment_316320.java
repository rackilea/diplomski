public HttpURLConnection createConnection(){

    try{            
        urlconnection=(HttpURLConnection)url.openConnection();      
    }catch(Exception e){
        Log.e("Can't create connections", e.getMessage());

    }

    return urlconnection;

}
public String doFunctionPost(JSONObject object){
    try{
        urlconnection=createConnection();
        urlconnection.setDoInput(true);
        urlconnection.setDoOutput(true);
        urlconnection.setRequestMethod(method);
        urlconnection.setUseCaches(false);
        urlconnection.setConnectTimeout(10000);
        urlconnection.setReadTimeout(10000);
        urlconnection.setRequestProperty("json", object.toString());
        urlconnection.setRequestProperty("Content-Type", "application/json");

        OutputStreamWriter out=new OutputStreamWriter(urlconnection.getOutputStream());
        out.write(object.toString());
           System.out.println(object.toString());
            out.close();
            httpResult=urlconnection.getResponseCode();
            System.out.println("Response Code"+ httpResult);
            result=readResponse();

    }catch(Exception e){
        Log.e("Response Error", e.getMessage());

    }finally{
        removeConnection();
    }
    return result;
}

public String readResponse(){
    try{
        if(httpResult==HttpURLConnection.HTTP_OK){
            BufferedReader buffer_reader=new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"utf-8"));
            String line=null;
            sb=new StringBuilder();
            while((line=buffer_reader.readLine())!=null){
                sb.append(line+"\n");
            }
            buffer_reader.close();
            System.out.println("buffer_reader"+sb.toString());
        }else{
            Log.e("Error on posting", urlconnection.getResponseMessage());
        }
    }catch(Exception e){
        Log.e("Error in Response", e.getMessage());
    }
    return sb.toString();
}