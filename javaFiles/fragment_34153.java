private Handler myHandler;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    myHandler = new Handler();
}

public void loadInBackround() {
    while(...) {
        // do stuff
    }
    final result = ....; 
    myHandler.post(new Runnable() {
            @Override
            public void run() {
                // update the layout with data from 'result'
                ...
            }
        });
}