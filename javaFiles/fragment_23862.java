File f = new File("Audio/Testing/mbgitr.wav");
try {
    ProcessBuilder pb = new ProcessBuilder("bash/extractAudio.sh", f.getAbsolutePath());
    pb.inheritIO();
    Process p = pb.start();  // Get the process
    p.waitFor();    // Wait until it terminates
}catch(IOException e){
    System.out.println("Oh no!");
}catch(InterruptedException e){
    System.out.println("InterruptedException");
}
System.out.println(new File("Audio/mbgitr.wav").exists());