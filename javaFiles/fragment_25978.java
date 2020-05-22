function insertIntoTable(){
var idArray = <%= (Arrays.toString(list1.get(0))).replace("[", "['").replace(", ","', '").replace("]","']") %>;
var nameArray = <%= (Arrays.toString(list2.get(0))).replace("[", "['").replace(", ","', '").replace("]","']") %>;
var len = idArray.length;
for (index = 0; index < len; index=index+1){
    var vname = idArray[index];
    var vid = nameArray[index];
    document.getElementById(vid).innerHTML = vname;
   }
}