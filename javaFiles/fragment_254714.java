BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
BufferedReader reader2 = new BufferedReader(new FileReader(filename2));

BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2, false));

String line1;
while((line1 = reader1.readLine()) != null){
    String[] columns = line1.split(",");

    String line2 = reader2.readLine();
    line2 += columns[columns.length - 1];

    bw.write(line2);
    bw.newLine();
}
reader1.close();
reader2.close();
bw.close();