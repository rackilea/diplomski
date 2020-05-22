int ar[]={ R.id.button1,R.id.button2,R.id.button3 };

        ArrayList<Button> bAL = new ArrayList<>();
        for (int i = 0; i < ar.length; i++){
            bAL.add((Button) findViewById(ar[i])); 
            bAL.get(i).setOnclickListener(listener);  // have a listener and just use the refereance

        }

View.onClickListener  listener =new View.onClickListener(){
..
}