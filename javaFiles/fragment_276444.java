private static void processFile(File theFile, List<String> gcArrayList,
        List<String> gcStringList, List<String> gcDateList){

    String line = "";
    String[] tokens = null;
    FileReader fr = null;
    BufferedReader bufReader = null;

   try {

        fr = new FileReader(theFile);

        bufReader = new BufferedReader(fr);
        while ((line = bufReader.readLine()) != null) {
            line = line.replace(",", ".");
            tokens = line.split(";");

            gcDateList.add(tokens[0]);
            gcStringList.add(tokens[1]);
            gcArrayList.add(tokens[2]);
            gcArrayList.add(tokens[3]);
            gcArrayList.add(tokens[4]);

        }

    } catch (FileNotFoundException es) {
        System.out.println("The file was not found.");

    } catch (NullPointerException e) {
        System.out.println("No files were chosen !");
    }

    catch (IOException e) {

        bufReader.close();

    }

    for (int i = 0; i < gcDateList.size(); i++) {
        SimpleDateFormat currentFormat = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat convertedFormat = new SimpleDateFormat(
                "dd MMM hh:mm:ss");

        gcDateList.set(i, convertedFormat.format(currentFormat
                .parse(gcDateList.get(i))));

    }

}