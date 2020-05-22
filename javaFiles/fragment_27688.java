input1.append(userId);
input1=input1.reverse();
String pair[]={"0","0","0","0","0","0","0","0"};
char[] character = input1.toString().toCharArray();

for(int i=0;i<character.length;i++)
{
  pair[i]=String.valueOf(character[i]);
}
int color = Color.argb((Integer.parseInt(pair[0]+pair[1])*2)+50, (Integer.parseInt(pair[2]+pair[3])*2)+50, (Integer.parseInt(pair[4]+pair[5])*2)+50, (Integer.parseInt(pair[6]+pair[7])*2)+50);
return color;