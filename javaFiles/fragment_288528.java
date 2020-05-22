package ayad.bslm.com.networkcoverage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class NetworkCoverageActivity extends AppCompatActivity {

    private TextView TV;
    private TelephonyManager TM;
    private List<NeighboringCellInfo> neighboringCellInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_coverage);

        TV = (TextView)findViewById(R.id.iv);
        Button getCellsInfoBtn = (Button)findViewById(R.id.getCellsInfoBtn);
        TM = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        getCellsInfoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                neighboringCellInfoList = TM.getNeighboringCellInfo();

                if(neighboringCellInfoList == null)
                    TV.setText("neighboringCellInfoList == null\n");
                else
                    TV.setText("There are " + neighboringCellInfoList.size() + " Cells\n");
            }
        });
    }
}