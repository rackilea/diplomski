changer = (Button) findViewById(R.id.change1);
changeme = (TextView) findViewById (R.id.changeme1);
changer.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View arg0) {
// TODO Auto-generated method stub
changeme.setText("Changed");
}
});