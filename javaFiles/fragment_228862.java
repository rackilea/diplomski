public static void main(String[] args) throws IOException, InterruptedException {

    ProcessBuilder p = new ProcessBuilder("cmd.exe", "/C", 
            "javac path\\of_your_file\\file.java 2> path\\of_your_file\\Error.txt");
    Process process = p.start();
    process.waitFor();//wait until your process finished 

    Scanner in = new Scanner(Paths.get("path\\of_your_file\\Error.txt"));
    while (in.hasNextLine()) {
        String line = in.nextLine();
        System.out.println(line);
    }
}