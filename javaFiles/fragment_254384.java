List<MyMemo> parentList = new ArrayList<>();
List<MyMemo> copyList = new ArrayList<>();
for (MyMemo memo : parentList)
{
   // create new instance of MyMemo and add to the list
   copyList.add(new MyMemo(memo));
}