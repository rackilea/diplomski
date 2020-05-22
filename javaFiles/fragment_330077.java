StringBuilder string = new StringBuilder();
string.append("'");
string.append(str1);
string.append("'");

if(!str1.equals(str2)){
    string.append("!");
}

string.append("'");
string.append(str2);
string.append("'");
System.out.println(string.toString());