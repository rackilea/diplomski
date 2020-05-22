static class Task extends TimerTask {
   static {
        try {
            URL url = Task.class.getResource("/resources/words.txt");
            Scanner scanner = new Scanner(url.openStream());
            System.out.println("" + scanner.next());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   }
}