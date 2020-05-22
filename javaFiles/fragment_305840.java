@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    LayoutInflater layoutInflater=(LayoutInflater)ListViewForDeleteContact.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View dfg= layoutInflater.inflate(R.layout.popupWindow,(ViewGroup)findViewById(R.id.popupId));

    TextView textView7 = (TextView) dfg.findViewById(R.id.textView7);
    textView7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // do something when the textview is clicked
        }
    });

    ... // for other textviews

    PopupWindow popupWindow=new PopupWindow(dfg,420,300,true);

    popupWindow.showAtLocation(dfg, Gravity.CENTER, 0, 0);
    popupWindow.setOutsideTouchable(true);

}