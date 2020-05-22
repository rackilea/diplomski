public class variousMethods {

public void checkNumbers(Context context, TextView displayArray, String[] latestNumbersArray) {
try {
        File myNumbersFile = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + context.getString(R.string.my_lotto_numbers_file))).toString());
        BufferedReader myNumbersFileReader = new BufferedReader(new FileReader(myNumbersFile));

        String inputLineOfMyNumbersFile;
        inputLineOfMyNumbersFile = myNumbersFileReader.readLine();

        while (inputLineOfMyNumbersFile != null) {
        String[] arrayOfInputLine = inputLineOfMyNumbersFile.split(" ");

        inputLineOfMyNumbersFile = myNumbersFileReader.readLine();
        while (inputLineOfMyNumbersFile != null) {
            displayArray.setText(Arrays.toString(inputLineOfMyNumbersFile));
            inputLineOfMyNumbersFile = myNumbersFileReader.readLine();
        }

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}