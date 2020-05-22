import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private ListView listView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ListView listView = (ListView)findViewById(R.id.listview);
    listView.setAdapter(new ServiceAdapter(this,sampleData()));

    Button btn = (Button)findViewById(R.id.select_btn);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayList<Service> actorList = ((ServiceAdapter)listView.getAdapter()).getSelectActorList();
            Toast.makeText(MainActivity.this,""+actorList.size(),Toast.LENGTH_LONG).show();
        }
    });

}


public ArrayList<Service> sampleData(){
    ArrayList<Service> dataList = new ArrayList<>();
    for(int i=0;i<30;i++){
        Service servic = new Service();
        servic.setName("Test"+i);
        dataList.add(servic);
    }

    return dataList;
}