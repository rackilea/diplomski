public void securityquestion(){
    final EditText txtUrl = new EditText(this);
    final EditText txtUrl2 = new EditText(this);
    final String[] ans1 = {""};
    final String[] ans2 = {""};
// Set the default text to a link of the Queen
        final int num = getradomquestionumber();
        String messge = "";
        if(num==1)
        {
            txtUrl.setHint("First Pet name");
            messge = "What is your first pet name?";
        }else{
            txtUrl.setHint("Mother's maiden name");
            messge = "What is your mother's maiden name?";
        }
        txtUrl2.setHint("User Name");
    new AlertDialog.Builder(LoginActivity.this)
            .setTitle("User Name")
            .setMessage("Enter UserName")
            .setView(txtUrl2)
            .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String url = txtUrl2.getText().toString();
                    ans1[0] = url;
                    // moustachify(null, url);

                    //ask question and get result
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Security Question")
                            .setMessage(messge)
                            .setView(txtUrl)
                            .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    String url = txtUrl.getText().toString();
                                    ans2[0] = url;
                                    // moustachify(null, url);

                                    //Now call or make server request
                                    HashMap<String , String> postDataParams = new HashMap<String, String>();
                                    postDataParams.put("key", String.valueOf(num));
                                    postDataParams.put("key2", ans1[0]);
                                    response = performPostCall("http://10.19.23.2/NEWS/SecurityQuestion.php", postDataParams);
                                    System.out.println("response -------------- "+response);
                                    if(response == ans2[0]){

                                    }else{
                                        System.exit(0);
                                    }
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            })
                            .show();
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                }
            })
            .show();
}