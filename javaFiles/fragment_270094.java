try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
    String line;
    while ((line=br.readLine())!=null) {
        System.out.println(line);
    }   
} catch (Exception e) {
    e.printStackTrace();
}