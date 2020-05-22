@Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        //Place the Intent Code Here.

        Intent intent = new Intent("android.intent.category.LAUNCHER");
        intent.setClassName("com.your.package","com.your.package.MainActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
            }
        }