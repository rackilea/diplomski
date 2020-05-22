Bundle bundle = intent.getBundleExtra(MainActivity.EXTRA_MESSAGE);

if (bundle != null) {
  String nome = bundle.getString("nome");
  String cognome = bundle.getString("cognome");
}