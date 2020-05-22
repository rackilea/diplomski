public static void main(String[] arg){
    File file = new File("out.txt");
    try (
        BufferedWriter bw = new BufferedWriter(new FileWriter(file))
    ) {
        for (int prime = 2; prime < 10000; ++prime) {
            boolean isPrime = true;
            final int limit = (int) sqrt(prime); // 
            for (int i = 2; i <= limit && isPrime; i++) {
                isPrime = prime % i != 0;
            }
            if (isPrime){
                bw.write(String.valueOf(prime));
                bw.newLine();
            }
        }
    } catch (IOException ex) {
        e.printStackTrace();
    }
}