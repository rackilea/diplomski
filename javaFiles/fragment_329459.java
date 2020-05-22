String str = "12342352397235823050237238523";
int []frequency = new int[10];
for(int i = 0; i < str.length(); ++i)
{
 int digit = str.charAt(i) - '0';
 frequency[digit] ++;
}
for(int i = 0; i < 10; ++i)
 System.out.println(frequency[i]);