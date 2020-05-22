alarmTime = params.getExtras().getString("alarmTime");
value = new ValueExchange();
value.setString(alarmTime);

player = MediaPlayer.create(getApplicatioContext(), R.raw.bensoundfunkyelement);
mJobExecutor = new MJobExecutor(player){

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(getApplicationContext(),alarmTime+" "+s,Toast.LENGTH_LONG).show();
        jobFinished(params,false);
    }
};
mJobExecutor.execute();
return true;