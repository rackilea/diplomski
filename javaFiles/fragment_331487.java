ArrayList<String> singleParts = new ArrayList<String>();

    try {
        int index = 0;
        Scanner scanner = new Scanner( new File("files/"+filename+".txt") );
        while ( scanner.hasNextLine() )  {
            String actualLine = scanner.nextLine();
            singleParts.add(actualLine);
        }
        scanner.close(); 
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch(Throwable te) {
        te.printStackTrace();
    }