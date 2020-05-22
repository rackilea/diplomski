String log = "/ws/priyapan-rcd/label" + "priyanka_label_test" + ".log";
File file = new File(log);

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null) {
        if (line.contains("script ran successfully")) {
            System.out.println("line found.go out of loop now");
            break;
        }
    }
}
catch (Exception e) {
    System.out.println("come inside loop to check logs.label update faild");
}