class A{
int counter =0;

public doJob(int jobCOunt){
    this.counter = jobCount
    new Job().execute();
}
class Job extends AsyncTask{
...
  protected void onPostExecute(Boolean success) {
    counter--;
    if(counter == 0){
        startActivity
    }
  }

}

}