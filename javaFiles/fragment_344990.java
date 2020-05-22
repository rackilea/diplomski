int [] studentmarks = new int[] {45,60,70,21,95,35,83,80,5,41,40,25};
System.out.println("studentmarks size = " + studentmarks.length);
for(int marks : studentmarks) {
      System.out.println("marks = " + marks); 
      if (marks < 40)
           System.out.println("marks less than 40 = " + marks);

}