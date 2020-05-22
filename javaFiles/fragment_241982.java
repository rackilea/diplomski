ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
Toast.makeText(getApplicationContext(), buttonView.isChecked()+"",Toast.LENGTH_SHORT).show();
        }
    });