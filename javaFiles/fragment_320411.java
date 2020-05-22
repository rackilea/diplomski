BufferedReader br = null;
BufferedWriter bw = null;
try {
    br = new BufferedReader(new FileReader(file));
    bw = new BufferedWriter(new FileWriter(file));
} catch (IOException e) {
    e.printStackTrace();
}
br.readLine();