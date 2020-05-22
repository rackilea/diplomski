public class UploadActivity extends AppCompatActivity {

    ...

    Optional<Uri> selectedFile = Optional.empty();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ...

        upload.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedFile.isEmpty() == false) {
                    uploadFile( selectedFile.get() );
                }
            }
        } );
    }

    ...

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        ...

        if (data != null) {
            selectedFile = Optional.of(data.getData()); 
            uploadFile(selectedFile.get()); // if you still want to do it here as well
        } else {
            selectedFile = Optional.empty();
        }

        ...
    }

    ...
}