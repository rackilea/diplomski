import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.toptoche.searchablespinnerlibrary.SearchableListDialog;

import java.util.ArrayList;
import java.util.List;

public class CustomSearchableSpinner extends Spinner implements View.OnTouchListener,
    SearchableListDialog.SearchableItem {

private Context _context;
private List _items;
private boolean isDataSetChanged;

public CustomSearchableSpinner(Context context) {
    super(context);
    this._context = context;
    this.isDataSetChanged = true;
    init();
}

public CustomSearchableSpinner(Context context, AttributeSet attrs) {
    super(context, attrs);
    this._context = context;
    this.isDataSetChanged = true;
    init();
}

public CustomSearchableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this._context = context;
    this.isDataSetChanged = true;
    init();
}

private void init() {
    _items = new ArrayList();
    setOnTouchListener(this);
}

@Override
public boolean onTouch(View v, MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        ArrayAdapter adapter = (ArrayAdapter) getAdapter();

        if (null != adapter) {

            if (isDataSetChanged) {
                if(_items.size() != 0) {
                    _items = new ArrayList();
                }
                for (int i = 0; i < adapter.getCount(); i++) {
                    _items.add(adapter.getItem(i));
                }
                isDataSetChanged = false;
            }
            SearchableListDialog searchableListDialog = SearchableListDialog.newInstance
                    (_items);
            searchableListDialog.setOnSearchableItemClickListener(this);
            searchableListDialog.show(((Activity) _context).getFragmentManager(), "TAG");
        }
    }
    return true;
}

@Override
public void onSearchableItemClicked(Object item, int position) {
    setSelection(_items.indexOf(item));
}

public void notifyDataChanged(Boolean hasDataChanged) {
    this.isDataSetChanged = hasDataChanged;
}
}