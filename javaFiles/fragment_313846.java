String str="a*nice*day";
String res="";

int j=0;

for(int i=0; i<str.length(); i++){

      if(str.charAt(i)=='*'){
            j = i + 1;
            break;
        }
    }

while(str.charAt(j) != '*'){
    res=res+str.charAt(j);
    j++;
}

System.out.println(res);