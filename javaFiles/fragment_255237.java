String sticker = "";

final Button button1 = (Button) findViewById(R.id.b1);
button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

           sticker = "allstickers";
        }
      });
final Button button2 = (Button) findViewById(R.id.b2);
button2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

           sticker = "teststickers";
        }
      });