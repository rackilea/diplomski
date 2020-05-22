Call<Example> call = service.Bind_Employee_Details_Based_On_Id(emailtoken);

call.enqueue(new Callback<Example>() {
    @Override
    public void onResponse(Call<Example> call, Response<Result> response) {
        //.getMessage is POJO method to listen for final json output
        List<Example> listResponse =response.body().getMessage();
        String fname=listResponse.get(0).getEmpFirstName();
        String lname=listResponse.get(0).getEmpLastName();
        String email=listResponse.get(0).getEmpEmail();
        String address=listResponse.get(0).getEmpAddress();
        String joindt=listResponse.get(0).getJoiningDate();

        etfname.setText(fname);
        etlname.setText(lname);
       etemail.setText(email);
       etaddress.setText(address);
       etjoindt.setText(joindt);
        progressDialog.dismiss();
    }