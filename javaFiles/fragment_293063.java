Scanner in = new Scanner(System.In);
int width = readInt("width", in);
int height = readInt("height", in);
for (int x = 0; x < width; x++){
  for (int y = 0; y < height; y++){
    //...
  }
}
private int readInt(String label, Scanner in){
  System.out.println("Enter board " + label);
  return in.nextInt();
}