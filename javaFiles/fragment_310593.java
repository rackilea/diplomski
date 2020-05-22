boolean equal=false;
String lines[] =new [10];

// or however long the array needs to be.

int count=0;
BufferedReader infile = new BufferedReader(new FileReader("<Name of file>"));
                do {

                    lines[count] = infile.readLine();
                   count++;
                } while (lines[count] != null);

for(int i=0;i<lines.length();i++) {

for(int j = i+1; j<lines.length()-1;j++){



if(lines[i].equals(lines[j])){
    equal=true; 
    system.out.print(lines[i]+" and "+lines[j]+" are equal");

}}}

if(!equal){
system.out.print("Sorry your text did not equal any text from the text file");
}