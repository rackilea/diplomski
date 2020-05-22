public class StackActivity extends AppCompatActivity {

    // your onCreate() but leave out the MediaPlayer references

    private void playSong() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl(getIntent().getStringExtra("SongUrl"));

        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                MediaPlayerSingleton.getInstance().play(uri.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("TAg", "aFailed");
            }
        });
    }
}