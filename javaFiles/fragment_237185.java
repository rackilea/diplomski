private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    update("Acc Data:x_adc,y_adc,z_adc!");

    public void update(String data) {
        String values[] = data.replace("Acc Data:", "").replace("!", "").split(",");
        String v1 = "";
        String v2 = "";
        String v3 = "";
        if(values != null && values.length == 3) {
            v1 = values[0];
            v2 = values[1];
            v3 = values[2];
        }
        tv1.setText(v1);
        tv2.setText(v2);
        tv3.setText(v3);
    }