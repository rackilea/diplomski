public void displayMensaje(View v) {
    Button button = (Button) v;
    String title = button.getText();
    String message = "Test " + title;
    Toast.makeText(ActividadUno.this, message, Toast.LENGTH_SHORT).show();
}