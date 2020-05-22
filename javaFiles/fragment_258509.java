String [][] DSA;
String [][] NC;
String [][] IW;   

void setup() {

  cp5 = new ControlP5(this);  
  cp5.addButton("Overview")
  .setValue(0)
  .setPosition(840, 10)
  .setSize(100, 19);

  cp5.addButton("Quadrant")
  .setValue(0)
  .setPosition(840, 30)
  .setSize(100, 19);

  cp5.addButton("Location Map")
  .setValue(0)
  .setPosition(840, 50)
  .setSize(100, 19);

  DSA = readFile("DSA.csv");
  NC = readFile("NC.csv");
  IW = readFile("IW.csv");

  size(950, 600);
  smooth();
  //noStroke();
  //Use system font 'Arial' as the header font with 12 point type
  h1 = createFont("Arial", 12, false);
  //Use system font 'Arial' as the label font with 9 point type
  l1 = createFont("Arial", 9, false);

}
String [][] readFile(String fileName) {
  //for importing csv files into a 2d array
  //by che-wei wang

  String lines[] = loadStrings(fileName);
  String [][] csv;
  int csvWidth=0;

  //calculate max width of csv file
  for (int i=0; i < lines.length; i++) {
    String [] chars=split(lines[i], ',');
    if (chars.length>csvWidth) {
      csvWidth=chars.length;
    }
  }

  //create csv array based on # of rows and columns in csv file
  csv = new String [lines.length][csvWidth];

  //parse values into 2d array
  for (int i=0; i < lines.length; i++) {
    String [] temp = new String [lines.length];
    temp= split(lines[i], ',');
    for (int j=0; j < temp.length; j++) {
      csv[i][j]=temp[j];
    }
  }
  return csv;
}

void Gluph() {
    println(DSA[1][3])
}