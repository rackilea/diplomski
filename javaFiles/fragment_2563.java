if( t.isNumber() ) {
    System.out.println("A number found");
} else {
    System.out.println("Not a number");
    return true; // stops execution
}
android.util.Log.v("MyApp", "my message");
return false; // does not stop execution