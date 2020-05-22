@Override
protected void onPostExecute(ArrayList<Person> personArrayList){

    Intent intent = new Intent(activity, ResultsActivity.class);
    intent.putParcelableArrayListExtra("personArrayList",personArrayList);
    activity.startActivity(intent);

}