public class Simulation {
    ArrayList fileOne;

    public ArrayList loadItem () throws Exception{

        File phaseOne = new File("phase-1.txt");
        fileOne = new ArrayList<FileRow>();
        Scanner scanner1 = new Scanner(phaseOne);
        while(scanner1.hasNextLine()){
            fileOne.add(new FileRow(scanner1.nextLine()));
        }
       return fileOne;
    }

    public ArrayList getFileOne() {
        return fileOne;
    }

}

class FileRow{
    String stringValue;
    int intValue;

    FileRow(String fileRowString){
        String [] splitString = fileRowString.split("=");
        this.stringValue = splitString[0];
        this.intValue = splitString[1];
    }
}