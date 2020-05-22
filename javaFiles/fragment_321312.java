public void onClick(View view) {

[...]

Intent intent = newIntent("com.sp.androidesp8266wifi.ServiceStatusUpdate");
intent.putExtra("parameterValue", parameterValue);
intent.putExtra("ipAddress", ipAddress);
intent.putExtra("portNumber", portNumber);
intent.putExtra("parameter", parameter);

// execute HTTP request
if(ipAddress.length()>0 && portNumber.length()>0) {
    startService(intent);
}