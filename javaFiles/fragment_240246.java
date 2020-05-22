ScrollView sv = new ScrollView(this);
    LinearLayout ll = new LinearLayout(this);
    ll.setOrientation(LinearLayout.VERTICAL);
    sv.addView(ll);
    for (int i =0; i < myArray.size(); i++) {
        TextView tv = new TextView(this);
        tv.setText(myArray.get(i).toString());
        tv.setTag("myTag_"+i);
        tv.setOnClickListener(this);
        ll.addView(tv);
    }

@Override
public void onClick(View v) {

    String tag = v.getTag(); // is myTag_6 for example


    //how do I tell the textviews apart?
}