InputStreamReader rs = new InputStreamReader(new FileInputStream(file));//create input stream reader object
BufferedReader br = new BufferedReader(rs);
String line = "";
line = br.readLine(); // here you read the first line in the file
//
File write = new File("output.KML");
write.createNewFile();
BufferedWriter out = new BufferedWriter(new FileWriter(write));
while(line != null){ // here you check that it's not null (it's not, you read the first line OK)
    line = br.readLine(); // here you read the second line (there is no second line, now line is null)
    if(line==" "){ // now you check if the line is a space character (this is wrong for 2 reasons, that's not how you compare strings, and a space character is not an empty string)
        System.out.print("empty");
    }else{
    data = line.split(",|:|[|]"); // here you call split() on line but line is null
    }