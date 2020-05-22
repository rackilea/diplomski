protected String getMyData(String param){
        HashMap<String, String> params = new HashMap<>();
        params.put("param1", apicall);
        params.put("param2", param);
        MyAsyncClass myAsyncClass = new MyAsyncClass(params);
       myData= myAsyncClass.execute().get();

        /* Here after finishing the task I want to return the data to the caller */
        return myData;
    }