subCastArrayList.clear();
// ^^^ clear the list instead of creating new one inside if or else
if (castArrayList.size() > 7)
{
    //subCastArrayList.addAll(castArrayList.subList(0,6));
    subCastArrayList.addAll(castArrayList.subList(0,7));
    // upper range is exclusive so use              ^ 
}else{
    subCastArrayList.addAll(castArrayList);
}
    castDetailAdapter.notifyDataSetChanged();
   // move notify outside , avoid redundant statements