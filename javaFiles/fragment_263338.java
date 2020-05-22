@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    /** your code **/


    profilePicture.setOnClickListener(new OnClickListener() {
        void onClick(View v) {
            Intent i = new Intent(this, ActivityToPickImage.class);
            startActivityForResult(i, 1); // you should define a constant instead of 1
        }
    });

}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 1) {
        if(resultCode == Activity.RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            //result is the code of the picked image
            //code to change profile picture goes here
        }
    }

}