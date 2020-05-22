case 17:
{
    REQUEST = 0; // set the request code to 0
    i = new Intent(Kviz.this, Finale.class); // set the intent to open final popup instead
    i.putExtra("brojTacnihOdgovora", brojacTacnihOdgovora); // set the extra name to match with the activity
    finish();
    break;
}