String values[] = {"Singles","5 in 1 series","Childrens Book"};
boolean first = true;
String inClause = "(";

for(String v : values){
    if(first){
        first = false;
    } else {
        inClause += ","
    }
    inClause += "'" + v + "'";
}
inClause += ")";