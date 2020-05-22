public void getContentTest1() {
        for (int i = 0; i < 3; i++) {
            String dataName = "Data[" + i + "].name";
            RestAuth auth = new RestAuth();
            auth.authAdmin()
                .parameters(
                    "a", 0 ,
                    "b", 3
                 )
            .expect().statusCode(200)
            .body(dataName,containsString("Test") )
            .get(myURL);
    }

}