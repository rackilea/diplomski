setContentView(R.layout.home);
Intent i = getIntent();
if (i != null) {
    //This means that the intent passed here was found
    String serviceName1 = i.getStringExtra("serviceName1");
    String service1HealthValue = i.getStringExtra("service1HealthValue");
    TextView service1= ((TextView) activity.findViewById(R.id.serviceName1));
    TextView service1Health= ((TextView) activity.findViewById(R.id.service1Health));
    service1.setText(service1Name);
    service1Health.setText(service1HealthValue);
}