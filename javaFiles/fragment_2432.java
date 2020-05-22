public void connectPassword(String nameuser, String password, MyInterface myInterface) {
    Api api = new Api();
    Call<Connection> call = api.getService().connectPassWord(nameuser, password);
    call.enqueue(new Callback<Connection>() {
        public void onResponse(Call<Connection> call, Response<Connection> response) {
            System.out.println(response.body().getToken());
            System.out.println("Connecter");
            User.this.token = response.body().getToken();
            myInterface.onSuccess(true);
            //return boolean her 
        }

        public void onFailure(Call<Connection> call, Throwable throwable) {
            System.out.print(throwable.getMessage());
            myInterface.onException(throwable.getMessage());
            // throw Exception her
        }
    });
}