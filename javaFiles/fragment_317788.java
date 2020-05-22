try(BufferedReader r = new BufferedReader(new FileReader("topSecretDocs.txt"))) {
    for(String line = r.readLine(); line != null; line = r.readLine()) {
        char[] chars = line.toCharArray();
        System.out.println("Split line to " + Arrays.toString(chars));
    }
} catch(IOException e) {
    dealWithException();
}