import java.io.BufferedReader;
import java.io.InputStreamReader;

...

public static String jpsMainClass() {
    // Determine the VMID (on most platforms, this will be the PID)
    final String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

    // Execute the 'jps' utility
    final Process jps = Runtime.getRuntime().exec(new String[] { "jps", "-l" });
    final BufferedReader br = new BufferedReader(new InputStreamReader(jps.getInputStream()));

    // Parse the output of jps to find the current VM by PID
    for (String line = br.readLine(); line != null; line = br.readLine()) {
        final String[] split = line.split(" ");
        if (pid.equals(split[0])) {
                return split[1];
            }
        }
    }
    return null;
}