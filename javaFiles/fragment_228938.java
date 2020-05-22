Object savedInstance = getLastNonConfigurationInstance();
    if(savedInstance instanceof MyDeleteAsyncTask){
        //it's a MyDeleteAsyncTask
    }else if(savedInstance instanceof MyLoadAsyncTask){
        //it's a MyLoadAsyncTask
    }