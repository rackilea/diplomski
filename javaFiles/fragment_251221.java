public void onClick(View view){
    newwords = new Words("", getApplicationContext());
    try {
        newwords.PlayWithRawFiles();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println("greshka");
        e.printStackTrace();
    }
}