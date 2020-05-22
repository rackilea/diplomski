int numberOfArg = 0;
numberOfArgs = ? //assign the number of arguments here

StringBuilder mySqlQuerySb = new StringBuilder();
mySqlQuerySb.append("Select ");  
for (int num = 0; num < numberOfArgs; num++)
{ 
    mySqlQuerySb.append("arg"+(num +1));
    if ((num +1) != numberOfArgs) {mySqlQuerySb.append(",");}
}
mySqlQuerySb.append(" from table");  
String mySqlQueryStr = mySqlQuerySb.toString();