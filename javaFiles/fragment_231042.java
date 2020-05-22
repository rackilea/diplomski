char [] sections =  {'A','A','B','A','A','B','B','A','A','B'};
int count = 0;
for(int i = 0; i < sections.length - 1; i++)
{
   if(sections[i] == 'A' && sections[i+1] == 'A')//compare with what you want to
   {
     count++;
   }
}
System.out.println(count);