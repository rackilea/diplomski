public static void main(String[] args) {
   Set<Thread> threads =  Thread.getAllStackTraces().keySet();
   threads.forEach(t -> {
   System.out.println(t.getName()+ " : " + t.isDaemon()); // count if isDaemon is true
   });

}