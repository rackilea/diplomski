import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class MainActivity extends Activity {

String myString;
private TextView myFileTypes;
File myFile = new File("/storage/extSdCard/my_pix");
File[] pictures = myFile.listFiles();
String[] stringArray;
boolean flag = false;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myFileTypes = (TextView) this.findViewById(R.id.textFileType);

    String path = Environment.getExternalStorageDirectory().toString();

    stringArray = new String[pictures.length];
    List<NameValuePair> myValuePair = new ArrayList<NameValuePair>();

    for (int i = 0; i < pictures.length; i++) {
        stringArray[i] = pictures[i].getName().split("\\.")[1];
        int j;
        for (j = 0; j < myValuePair.size(); j++) {
            if (myValuePair.get(j).getName().equals(stringArray[i])) {
                int addOne = Integer
                        .parseInt(myValuePair.get(j).getValue()) + 1;
                myValuePair.set(j, new BasicNameValuePair(stringArray[i],
                        String.valueOf(addOne)));
                break;
            }
        }

        if (j == myValuePair.size()) {
            myValuePair.add(new BasicNameValuePair(stringArray[i], String
                    .valueOf(1)));

        }

    }

    for (NameValuePair nameValuePair : myValuePair) {

        myFileTypes.append(nameValuePair.getName() + " - "
                + nameValuePair.getValue()) + "\n";
    }

}

}