public class ReadValidationFile {

public static void main(String[] args) {

    List<String> validationFile = new ArrayList<>();

    try(BufferedReader br = new BufferedReader(new FileReader("validation_small.csv"));){