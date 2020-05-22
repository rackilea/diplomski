System.out.println(renderMessage(vector[i]));
...
public String renderMessage(Object[] obj){
    return "nr=" + obj[0]+ 
    "nume=" + obj[1]+
    "prenume=" + obj[2]+
    "nota=" + obj[3];
}