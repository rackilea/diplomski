plus.setOnClickListener(new Button.OnClickListener() {
    public void onClick(View view) {
        try {
            final String n1 = num1.getText().toString();
            final String n2 = num2.getText().toString();
            float sum = Integer.valueOf(n1) + Integer.valueOf(n2);
            String a = Float.toString(sum);
            a = a.trim();
            resu.setText(""+a);
        } catch(Exception e) {
            resu.setText(""+e);
        }
    }
});