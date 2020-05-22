switch(position){
case 0:
 fragmentManager.beginTransaction()
        .replace(R.id.container, SuikodenFragment.newInstance(position + 1)).commit();
//similar for others
}