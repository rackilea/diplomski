List<MyPojo> lstPojo = new ArrayList<~>;
for (int z = 0; z < jArrayMenu.length(); z++)
{
    JSONObject MnuDetail = jArrayMenu.getJSONObject(z);
    int operatorIdMenu = MnuDetail.getInt("opetor_id");
    //cmd_operator_test.add(MnuDetail.getInt("opetor_id"));
    if (OperaID == operatorIdMenu)
    {
        lstPojo.add(new MyPojo(MnuDetail.getString("cmd_id"),
                               MnuDetail.getString("cmd_name"),
                               MnuDetail.getString("cmd_instruction"),
                               MnuDetail.getString("cmd_commentaire")));
    }

}
CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,
            android.R.layout.simple_spinner_item,
            lstPojo);
rv.setAdapter(customAdapter);