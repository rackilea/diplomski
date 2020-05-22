String name = "";
boolean saved = false;

for(int line = 0; line < singleParts.size(); line++) {
    for(int char = 0; char < singleParts.get(line).length(); char++) {
         if(char<singleParts.get(line).indexOf(':') {
             name += singleParts.get(line).charAt(char);
         }
    }
}