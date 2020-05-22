String str =  "02101403101303101303140";
StringBuilder sb = new StringBuilder();
for(int i=0; i < str.length(); i+=2)
  for(int j =0; j < Integer.parseInt(String.valueOf(str.charAt(i))); j++)
    sb.append(str.charAt(i+1));

System.out.print(sb.toString());