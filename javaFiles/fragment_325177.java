Gson gson = new GsonBuilder().create(); 
    AccountModel am = gson.fromJson("{\"result\":\"success\",\"data\":    {\"Items\":[{\"id\":\"5b7c8950-692a-11e6-a3c9- 03b4285ed321\",\"accountName\":\"5b7c8950-692a-11e6-a3c9-03b4285ed321@finanskutusu.com\",\"userId\":\"111903139847063022019\"}],\"Count\":1,\"ScannedCount\":12}}", AccountModel.class);
    System.out.println(am.getResult());
    System.out.println(am.getData().getCount());
    Items i[] = am.getData().getItems();
    System.out.println(i[0].getAccountName());