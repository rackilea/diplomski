BufferedReader in = new BufferedReader(new FileReader("file path"));
String str;
int countMale=0;
int countFemale=0;
List<String> list = new ArrayList<String>();
while((str = in.readLine()) != null){
    list.add(str);
}

for(String s:list){
    String[] splitValues=s.split("|");
    for(int i=0;i<splitValues.length;i++){
        if(splitValues[i].equalsIgnoreCase("m")){
            countMale++;
        }
        else if(splitValues[i].equalsIgnoreCase("f")){
            countFemale++;
        }
    }
}
System.out.println("Number of males: "+countMale);
System.out.println("Number of females: "+countFemale);