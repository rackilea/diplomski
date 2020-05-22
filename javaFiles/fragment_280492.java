ArrayList<Integer> Data=new ArrayList<Integer>();
for(int data:Data)
{
   System.out.println( Data.indexOf(data)+1 );
   Data.remove(Data.indexOf(data));//to ensure the index is correct even if there are duplicates
}