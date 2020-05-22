import java.util.Currency;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomAdapter extends CursorAdapter{

    public CustomAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Currency moeda = Currency.getInstance(Locale.getDefault());
        TextView tvMoeda = (TextView)view.findViewById(R.your_id);//your textView id here
        tvMoeda.setText(moeda.getSymbol(Locale.getDefault()));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item, parent, false);//your layout here
        bindView(v, context, cursor);
        return v;
    }

}