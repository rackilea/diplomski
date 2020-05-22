BufferedReader br = new BufferedReader(new FileReader(file));
int index = 10;
while (lineNumber < index - 1)
    {
        lineNumber++;
        br.readLine();
    }
String lineYouWant = br.readLine();
if (lineYouWant.isEmpty()) br.close();
// Do stuff with lineYouWant
br.close();