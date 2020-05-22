try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    br.readLine();
} catch (IOException e) {
    e.printStackTrace();
}