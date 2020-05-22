static String port_text;
static String ip_text;
static int portnum;

public void onClick(View v) {

    if(v.getId() == btn1.getId())
    {
        port_text = port.getText().toString();
        ip_text = ip.getText().toString();

        portnum = Integer.parseInt(port_text);  


        /**.....exception handling operations...... 

        **/

            Intent myIntent = new Intent(Login.this, Loader.class);

            startActivity(myIntent);        

    }
}