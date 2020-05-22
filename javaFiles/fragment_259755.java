private static TextArea textArea;

public static void main( final String[] args) throws IOException{
    Speechrec sp1 = new Speechrec();
    textArea = new TextArea(sp1.dr,05,30);
    Button button = new Button("Start speaking");
    // and so on...
}

while (true) {

        Result result = recognizer.recognize();

        if (result != null) {

            String resultText = result.getBestFinalResultNoFiller();

            dr = resultText;

            textArea.setText(resultText);

            // or:

            textArea.append(resultText);
        } 
}