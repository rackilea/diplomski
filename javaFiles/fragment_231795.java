public class MJobScheduler extends JobService {
    MJobExecutor mJobExecutor;
    String alarmTime;
    ValueExchange value;

    @Override
    public boolean onStartJob(final JobParameters params) {
        alarmTime = params.getExtras().getString("alarmTime");
value = new ValueExchange();
value.setString(alarmTime);
mJobExecutor = new MJobExecutor(getApplicationonContext()){//pass context here..

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(getApplicationContext(),alarmTime+" "+s,Toast.LENGTH_LONG).show();
        jobFinished(params,false);
    }
};
mJobExecutor.execute();
return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
mJobExecutor.cancel(false);
return false;
    }
    }