package com.example.checkdoubltap;

  import android.content.Context;
  import android.util.Log;
  import android.view.View;
  import android.view.ViewGroup;
  import android.widget.BaseAdapter;
  import android.widget.CheckBox;
  import android.widget.CompoundButton;
  import android.widget.CompoundButton.OnCheckedChangeListener;

  public class CheckBoxAdapter extends BaseAdapter {

private Context mContext;
private String[] mCountries;
private boolean[] mIsChecked;

public CheckBoxAdapter(Context context, String[] countryStrings, boolean[] isChecked) {
    mContext = context;
    mCountries = countryStrings;
    mIsChecked = isChecked;
}

@Override
public int getCount() {
    if(mCountries != null)
        return mCountries.length;
    return 0;
}

@Override
public Object getItem(int position) {
    return null;
}

@Override
public long getItemId(int position) {
    return 0;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    CheckBox view = new CheckBox(mContext);
    view.setChecked(load(position));
//  view.setChecked(mIsChecked[position]);
    view.setText(mCountries[position]);
    view.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Log.d("Check","Changing position to"+position+" "+isChecked);
            mIsChecked[position] = isChecked;
            savebox(position,isChecked);
        }
    });
    return view;
}

private boolean load(int position) { 
    SharedPreferences sharedPreferences = ((Activity) mContext).getPreferences(Context.MODE_PRIVATE);
    return sharedPreferences.getBoolean(""+position, false);
}



private void savebox(int position, final boolean isChecked) {
    SharedPreferences sharedPreferences = ((Activity) mContext).getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean(""+position, isChecked);
    editor.commit();
    Log.d(TAG, "checkbox is saved");
}
  }