SimpleDateFormat format = new SimpleDateFormat("HH:mm");
long difference = 0;
long difference1 = 0;
try {
    Date dateb = format.parse(b); //time in
    Date datec = format.parse(c); //time out
    difference = datec.getTime() - dateb.getTime();
    int minutes = (int) ((difference / (1000 * 60)) % 60);
    int hours = (int) ((difference / (1000 * 60 * 60)) % 24) - 1;
    editTextH1.setText((hours + ":" + minutes));
} catch (Exception e) {
     System.err.println("ouch!");
}
try {
    Date dateb1 = format.parse(d);
    Date datec1 = format.parse(e1);
    long difference1 = datec1.getTime() - dateb1.getTime();
    int minutes1 = (int) ((difference1 / (1000 * 60)) % 60);
    int hours1 = (int) ((difference1 / (1000 * 60 * 60)) % 24) - 1;
    editTextH2.setText((hours1 + ":" + minutes1));
 } catch (Exception e) {
    System.err.println("ouch!");
 }
long difference4 = difference + difference1;
int minutes4 = (int) ((difference4 / (1000 * 60)) % 60);
int hours4 = (int) ((difference4 / (1000 * 60 * 60)) % 24) - 1;
editText8.setText((hours4 + ":" + minutes4));