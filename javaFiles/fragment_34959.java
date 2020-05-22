BufferedReader file = new BufferedReader(new FileReader("Avar.txt"));
String line;
while((line = file.readLine()) != null){
    if(line.charAt(0) >= 48 && line.charAt(0) <= 57 ){
        String number = line.substring(0, 2);
        int x = Integer.valueOf(number);
        //do something with x
    }
}       
file.close();