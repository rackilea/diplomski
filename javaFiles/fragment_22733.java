BufferedReader input = new BufferedReader(
    new InputStreamReader(consoleProcess.getInputStream()));

String text;

while ((text = input.readLine()) != null)
{
    textarea.append(text + "\n");
}
input.close();