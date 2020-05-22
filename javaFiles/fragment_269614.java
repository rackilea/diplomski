List<Integer> tickets = new ArrayList<>();
try (BufferedReader ind = new BufferedReader(new FileReader("Billet_priser.txt")){
    String line = null;
    while ((line = ind.readLine()) != null) {
        String[] bits = line.split(" ");     
        tickets.add(Integer.parseInt(bits[1]));
    }
} 
catch (IOException e) {
    e.printStackTrace();
}