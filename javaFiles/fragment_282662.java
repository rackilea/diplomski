final String regex = ",(?!(?:(?:[^\\(\\)]*[\\(\\)]){2})*[^\\(\\)]*$)";
final String string = "(1,3,4,(3,4,21),55,69,12,(3,8),9)";

String[] result=string.split(regex);
int len=result.length;
for(int i=0;i<len;i++)
{

// the following two if condition is necessary to remove the start and end brace
// many other and probably better alternatives could be there to remove it 

 if(result[i].contains("(") && !result[i].contains(")"))
  result[i]=result[i].replace("(","");
 else if(result[i].contains(")") && !result[i].contains("("))
  result[i]=result[i].replace(")","");   
}

System.out.println(java.util.Arrays.toString(result));