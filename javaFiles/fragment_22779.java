String user_input = "<value from edit text>";
String resolved_kana = (String) getResources().getText(getResources().getIdentifier(user_input, "string", "<application package class>"),"");
if (resolved_kana.equals(kana_char) {
    Toast.makeText(getApplicationContext(), "Sugoi!", Toast.LENGTH_SHORT).show();
} else {
    Toast.makeText(getApplicationContext(), "wrong!", Toast.LENGTH_SHORT).show();
}