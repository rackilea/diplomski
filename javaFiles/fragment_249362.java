private class doLoginTask extends AsyncTask<String, Integer, String>{

    private ProgressDialog pb=null;
    //private String response=null;
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
                    //Progress show
        pb=ProgressDialog.show(ClubLoginActivity.this, "", "Processing");
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub

        //add your work here..

        return myWork();
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        pb.dismiss();
                    //code after dismiss it.
                    Intent intent2 = getIntent();
    String count = intent2.getStringExtra("result2");
    Intent intent = new Intent(this, PreposisiRemoval.class);

    intent.putExtra("resultFilter", resultFilter.toString());
    intent.putExtra("count", result);
    startActivity(intent);

    }
}
    String myWork(){

    String test = ((TextView)findViewById(R.id.textView7)).getText().toString();
    String[] preposisi = {"akibat", "atas", "bagai", "bagi", "berkat", "dalam", "dari", "demi", "dengan", "di", "hingga", "karena", "ke", "kecuali", "lewat", "oleh", "pada", "sampai", "sejak", "seperti", "tanpa", "tentang", "untuk"};
    StringBuilder resultFilter = new StringBuilder();

    Scanner fip1 = new Scanner(test);
        while (fip1.hasNext()){
                int flag = 1;
                String s1 = fip1.next();
                for (int i = 0;i<preposisi.length; i++){
                    if (s1.equals(preposisi[i])){
                        flag=0;
                    }
                    }   
                    if(flag!=0){
                        System.out.println(s1);
                        resultFilter.append(s1+'\n');
                    }


}
        return resultFilter.toString();
}