Intent intent = new Intent(Activity1.class,Activity2.class);
//I use the String class name as a key value, but you can use whatever key
intent.putExtra(String.class.getCanonicalName(), myString);
startActivity(intent);
//Or this other method if you want to retrieve a result from Activity2
//startActivityForResult(intent,Activity2);