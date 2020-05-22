chkIos.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View view) {        
    if (v.isChecked()) {
        multiChoiceView.setVisibility(View.VISIBLE);
    } else {
        multiChoiceView.setVisibility(View.GONE);
    }

});