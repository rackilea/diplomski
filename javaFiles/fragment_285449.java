String str = "1,,,,,2,3,,1,,3,,";
int k = 0;
int startPoint = 0;
ArrayList<String> arrayList = new ArrayList<>();
for (int i = 0; i < str.length(); i++)
{
  if (str.charAt(i) == ',')
  {
      k++;
      if (k == 4)
      {
          String ab = str.substring(startPoint, i+1);
          System.out.println(ab);
          arrayList.add(ab);
          startPoint = i+1;
          k = 0;
      }
  }
}