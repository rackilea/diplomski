import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class PhotoEditorActivity extends AppCompatActivity {
FragmentManager fragManager;
FragmentTransaction fragTransaction;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photo_editor);

    fragManager=getFragmentManager();
    fragManager.findFragmentById(R.id.fragmentContainer);
    fragTransaction=fragManager.beginTransaction();
    fragTransaction.replace(R.id.fragmentContainer, new PhotoEditorFragment());
    fragTransaction.commit();

}
}