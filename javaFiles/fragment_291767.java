package tt.tt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Test extends Activity implements OnClickListener {

    List<Format> formats = new ArrayList<Format>();
    TableRow row;
    TableLayout layout;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.make:
                make();
                break;
            case R.id.retrieve:
                retrieve();
                break;
        }
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.table);
        layout = (TableLayout) this.findViewById(R.id.table);
        Button make = (Button) this.findViewById(R.id.make);
        make.setOnClickListener(this);
        Button retrieve = (Button) this.findViewById(R.id.retrieve);
        retrieve.setOnClickListener(this);
    }

    public void make() {
        Random r = new Random();
        Format f = new Format();
        f.position = r.nextInt(10);
        f.name = r.toString();
        f.points = r.nextLong();
        formats.add(f);

        FileOutputStream out;
        try {
            out = this.openFileOutput("format", Activity.MODE_PRIVATE);
            ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(out));
            output.writeObject(formats);
            output.flush();
            output.close();
        }
        catch (FileNotFoundException e) {
            Log.d("Format", "Can't save data", e);
        }
        catch (IOException e) {
            Log.d("Format", "Can't save data", e);
        }
    }

    public void retrieve() {
        formats.clear();
        FileInputStream in;
        try {
            in = this.openFileInput("format");
            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(in));
            formats = (ArrayList<Format>) input.readObject();
            input.close();
        }
        catch (FileNotFoundException e) {
            Log.d("Format", "Can't load data", e);
        }
        catch (StreamCorruptedException e) {
            Log.d("Format", "Can't load data", e);
        }
        catch (IOException e) {
            Log.d("Format", "Can't load data", e);
        }
        catch (ClassNotFoundException e) {
            Log.d("Format", "Can't load data", e);
        }
        int count = 0;
        while (count < formats.size()) {
            Format f = formats.get(count);
            row = new TableRow(this);
            TextView temp = new TextView(this);
            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            temp.setText(Integer.toString(f.position));
            row.addView(temp, 0, params);
            temp = new TextView(this);
            temp.setText(f.name);
            row.addView(temp, 1, params);
            temp = new TextView(this);
            temp.setText(Long.toString(f.points));
            row.addView(temp, 2, params);
            layout.addView(row);
            count++;
        }
    }
}