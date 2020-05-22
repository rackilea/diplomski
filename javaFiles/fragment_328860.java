try {
      Intent myIntent = new Intent(this,Class.forName("com.mypackage.myMainActivity"));
      startActivity(myIntent );
} catch (ClassNotFoundException e) {
     e.printStackTrace();
}