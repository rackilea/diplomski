public static void main(String Argv[]) {
try {
    String ls_str;

    Process ls_proc = Runtime.getRuntime().exec("pathtoyourbat/generateK.bat");

    // get its output (your input) stream

    DataInputStream ls_in = new DataInputStream(
                                      ls_proc.getInputStream());

    try {
    while ((ls_str = ls_in.readLine()) != null) {
        System.out.println(ls_str);
    }
    } catch (IOException e) {
    System.exit(0);
    }
} catch (IOException e1) {
    System.err.println(e1);
    System.exit(1);
}

System.exit(0);
}