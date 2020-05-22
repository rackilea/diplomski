package rapid_process;

import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
//import com.rapidminer.operator.io.ExcelExampleSource;
import com.rapidminer.tools.XMLException;
import java.io.File;
import java.io.IOException;
import java.lang.Object;

public class process {

public static void main(String[] args) throws IOException, XMLException, OperatorException {
    /*// Path to process-definition
    final String processPath = "C:/Users/Evie/.RapidMiner/repositories/Local Repository/processes/Compare ROCs.rmp";

    // Init RapidMiner
    RapidMiner.setExecutionMode(ExecutionMode.COMMAND_LINE);
    RapidMiner.init();

    // Load process
    final com.rapidminer.Process process = new com.rapidminer.Process(new File(processPath));
    process.run();*/

    try {
          RapidMiner.setExecutionMode(RapidMiner.ExecutionMode.COMMAND_LINE);
          RapidMiner.init();

          Process process = new Process(new File("C:/Users/YourUser/.RapidMiner/repositories/Local Repository/processes/Compare ROCs.rmp"));

          process.run();

        } catch (IOException | XMLException | OperatorException ex) {
          ex.printStackTrace();
        }

    }

}