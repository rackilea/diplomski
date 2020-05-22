public static class InnerClass {
    String innerString = "bar";
    Ideone newOne = new Ideone();
    {
       newOne.setTop(innerString ); //not legal
    }

}