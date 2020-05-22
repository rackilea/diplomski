public abstract class MyAbstractTask extends AsyncTask<String, String, String> {

 protected void someMethod() { //note that i change private to protected
  final RestAdapter restAdapter = new RestAdapter.Builder().setServer("http://10.0.2.2:8080").build();
  final MyTaskService apiManager = restAdapter.create(MyTaskService.class);
 }

}