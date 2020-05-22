import java.awt.EventQueue;
import javax.swing.JOptionPane;
import java.io.File;

class BigMemory {

    public static void main(String[] args) throws Exception {
        if (args.length==0) {
            ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-Xmx1024m",
                "BigMemory",
                "anArgument"
                );
            pb.directory(new File("."));
            Process process = pb.start();
            process.waitFor();
            System.out.println("Exit value: " + process.exitValue());
        } else {
            Runnable r = new Runnable() {
                public void run() {
                    JOptionPane.showMessageDialog(
                        null,
                        "Max Memory: " +
                        Runtime.getRuntime().maxMemory() +
                        " bytes.");
                }
            };
            EventQueue.invokeLater(r);
        }
    }
}