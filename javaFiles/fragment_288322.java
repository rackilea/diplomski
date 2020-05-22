import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Browse extends AppCompatActivity {

ListView lvCampsites;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_browse);

    lvCampsites= findViewById(R.id.lvCampsites);

    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<Campsite> campsites = db.getAllCampsites();

    //Instance of custom adapter 
    CampsitesListAdapter adapter = new CampsitesListAdapter(this ,   campsites);
   //Setting adapter to listview
   lvCampsites.setAdapter(adapter);
}