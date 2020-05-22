import java.io.BufferedReader;
import java.io.InputStreamReader;

try {
    final Process process = Runtime.getRuntime().exec("file --mime-type " + basePath + "/" + fileName);

    final BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

    String text = "";

    String s;
    while ((s = stdInput.readLine()) != null) {
        text += s;
    }

    return text.split(": ")[1];
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}