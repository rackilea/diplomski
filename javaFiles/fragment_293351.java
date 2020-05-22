public class ABC extends AppCompatActivity{

@Override
protected void onCreate(Bundle savedInstanceState) {

    ......
    final LiveData<UserDetailEntity> userDetailObservable = db.informationModel.getUserDetails();
    userDetailObservable.observe(this, new Observer<UserDetailEntity >() {

        @Override
        public void onChanged(@Nullable UserDetailEntity userDetailEntity) {
            ..... some Code 

            userDetailObservable.removeObserver(this);

        }
    }
}