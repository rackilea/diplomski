1 for(int x=1; x<= 4; x++)
2 {
3  for(int y=-1; y <= 3; y++)
4  {
5   System.out.println("Enter student name for row "+x+"column "+y+" ==>");
6   userName[x-1][y-1] = (String) System.in.read();
7  }
8 }