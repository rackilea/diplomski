public static void numGamesWithHomeTeam(String fileName) throws IOException{
File statsFile = new File(fileName);
Scanner input1 = new Scanner(statsFile);
String line = null;
Scanner lineScan = new Scanner(line);

int count = 0;
while(input1.hasNextLine()){
    line = input1.nextLine();
    if(line.contains("@")){
        count++;
    }   
} 
System.out.println("Number of games with a home team: " + count);}