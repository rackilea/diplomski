void displayOpts(){
    List<UserAccountDetailsModel> accounts = userAccountDetailsSqliteModel.getAccounts();
    //deleted line
    //next line changed
    radioGroup.setOrientation(LinearLayout.VERTICAL);
    for (UserAccountDetailsModel user : accounts){
        CompanyLocationsModel company = companyLocationSqliteModel.getCompany(user.getCompany_id());
        RadioButton rdbtn = new RadioButton(this);
        rdbtn.setTextSize(17);
        rdbtn.setId(company.getId());
        rdbtn.setText(user.getFirst_name() + " "+user.getLast_name() + " ---- " + company.getName());
        //next line changed
        radioGroup.addView(rdbtn);
    }
    //deleted line
    //next line changed
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
           // checkedId is the RadioButton selected
            Log.i("test", "Checked is "+checkedId);
        }
    });
}