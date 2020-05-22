1. passIntent1()
private void passIntent1(){
     Intent intent = new Intent(getBaseContext(), SecondActivity.class);
     intent.putExtra("INTENT_VALUE", "A");
     intent.putExtra("FRAGMENT_A", value for A);
     startActivity(intent);
}

2. passIntent2()
private void passIntent2(){
     Intent intent = new Intent(getBaseContext(), SecondActivity.class);
     intent.putExtra("INTENT_VALUE", "B");
     intent.putExtra("FRAGMENT_B", value for B);
      startActivity(intent);
 }