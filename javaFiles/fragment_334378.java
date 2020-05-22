String PosItem = (String)arg0.getItemAtPosition(arg2);

Intent itemIntent = new Intent(getBaseContext(), TempCalEx.class);
String exIntent = "";

if ("Wall Pushup".equals(PosItem))
    exIntent = "wallpushup";
else if ("Knees Pushup".equals(PosItem))
    exIntent = "kneepushup";
else if ("Regular Pushup".equals(PosItem)) {
    exIntent = "regpushup";
    Toast.makeText(CalExercises.this, "List Detect Test Success - Pushup",Toast.LENGTH_LONG).show();
} else if ("Pullup".equals(PosItem)) {
    exIntent = "pullup";
    Toast.makeText(CalExercises.this, "List Detect Test Success - Pullup", Toast.LENGTH_LONG).show();
}

itemIntent.putExtra("exString", exIntent);
startActivity(itemIntent);