try{
        PropertyInfo propertyInfo1 = new PropertyInfo();
        properties.clear();

        propertyInfo1 = new PropertyInfo();
        propertyInfo1.setName("Module_id");
        propertyInfo1.setType(String.class);
        propertyInfo1.setValue(Utils.selectedModule_id);
        properties.add(propertyInfo1);

        ServiceParams serviceparams=new ServiceParams("GetInfo", properties);
        ServiceParams serviceparams2=new ServiceParams("GetInfo_Photo", properties);

        FirstAsyncTask asyncTask = new FirstAsyncTask(); // First
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, serviceparams);
        SecondAsyncTask asyncTask2 = new SecondAsyncTask(); // Second
        asyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, serviceparams2);

    } catch (Exception e) {
        Toast.makeText(Info.this, "Please check your internet connection.", Toast.LENGTH_LONG);
    }