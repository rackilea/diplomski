import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhysicalCores
{
    public static void main(String[] arguments) throws IOException, InterruptedException
    {
        int physicalNumberOfCores = getPhysicalNumberOfCores();
        System.out.println(physicalNumberOfCores);
    }

    private static int getPhysicalNumberOfCores() throws IOException, InterruptedException
    {
        ProcessBuilder processBuilder = new ProcessBuilder("wmic", "CPU", "Get", "NumberOfCores");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        String processOutput = getProcessOutput(process);
        String[] lines = processOutput.split(System.lineSeparator());
        return Integer.parseInt(lines[2]);
    }

    private static String getProcessOutput(Process process) throws IOException, InterruptedException
    {
        StringBuilder processOutput = new StringBuilder();

        try (BufferedReader processOutputReader = new BufferedReader(
                new InputStreamReader(process.getInputStream())))
        {
            String readLine;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                processOutput.append(readLine);
                processOutput.append(System.lineSeparator());
            }

            process.waitFor();
        }

        return processOutput.toString().trim();
    }
}