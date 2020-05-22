package maniac.professionalchartsfree.Utilities;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

import maniac.professionalchartsfree.R;

/**
 * Created by saad.rafique on 1/5/2018.
*/

public class CustomMarkerView extends MarkerView
{
private TextView tvContent;

public CustomMarkerView(Context context, int layoutResource, int valueSize, int valueColor)
{
    super(context, layoutResource);
    // this markerview only displays a textview
    tvContent = findViewById(R.id.tvContent);
    tvContent.setTextSize(valueSize);
    tvContent.setTextColor(valueColor);
}

// callbacks everytime the MarkerView is redrawn, can be used to update the
// content (user-interface)

@Override
public void refreshContent(Entry e, Highlight highlight)
{
    tvContent.setText("x: " + e.getX() + "\n" +"y: " + e.getY()); // set the entry-value as the display text
}

}