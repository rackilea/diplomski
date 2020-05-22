public class GovernorLocalDataSource implements GovernorDataSource {

    @Override
    public void getGovernors(@NonNull GetGovernorsCallback callback) {
       Gson gson = new GsonBuilder()
               .registerTypeAdapterFactory(GovernorAdapterFactory.create())
               .create();
       List<Governor> governors;

       String governorsString = mSharedPreference.getString(GOVERNORS, EMPTY_STRING);
       if (governorsString.isEmpty()) {
           governors = populateGovernors();
           governorsString = gson.toJson(governors);
           mSharedPreference.edit().putString(GOVERNORS, governorsString).commit();
       } else {
           Type type = new TypeToken<ArrayList<Governor>>() {}.getType();
           governors = gson.fromJson(governorsString, type);
       }

       if (governors != null && governors.size() > 0) {
           callback.onSuccess(governors);
       } else {
           callback.onFailure();
       }

    }

}