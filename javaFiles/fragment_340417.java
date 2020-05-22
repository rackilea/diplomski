try {
    String log = "#" + Main.Runcnt + " Best#: " + Main.indx + " BestScore: " + Main.val + " MaxCnt: " + Main.max_cnt + "\n";
    Files.write(Main.pathFile, log.getBytes(), Files.exists(Main.pathFile) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
} catch (IOException e) {
    // exception handling 
}