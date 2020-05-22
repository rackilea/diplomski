String strToSearch = yourString + " [";//"bob ["

for (int i = 0; i < list.size(); i++){
    if (list.get(i).startsWith(strToSearch)){
         neededIndex = i;
         break;
    }
}