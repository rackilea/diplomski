Object o = java.util.Calendar.getInstance().getTime().toString();
// o is declared as an object but is really a String

// this is fine
String s1 = (String) o;
// this is also fine because String implements CharSequence
CharSequence cs = (CharSequence) o;