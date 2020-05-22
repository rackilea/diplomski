float[] floats = new float[100];  // adjust as needed

String fileName = "numbers.txt";
File f = new File(fileName);
BufferedReader br = new BufferedReader(new FileReader(f));

String line = "";

int i = 0;

while( (line = br.readLine()) != null) {

    if(line == null || line.isEmpty()) continue;  // just in case there are empty lines in file
    floats[i] = Float.parseFloat(line);
    i++;
}

br.close();

for (float number : floats) {
    if (number > 2.0) {
        System.out.println(number);
    }
}