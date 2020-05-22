Intent in = new Intent(activtiy1, secondact.class);
Bundle b = new Bundle();
b.putString("key", "string_to_pass");
.
.
.
in.putextras(b);
startActivity(in);