List<String> listA = ...;
List<String> listB = ...;
List<String> listC = ...;

//note: the lists could have different lengths so this is unsafe
//I'll leave this as an excercise for you
int listLength = listA.size(); 

String array[][] = new String[listLength][];

for( int i = 0; i < listA.size(); i++ )
{
  array[i] = new String[3];
  array[i][0] = listA.get( i );
  array[i][1] = listB.get( i );
  array[i][2] = listC.get( i );
}