@Override
public int getViewTypeCount() {
   return 2;
}

@Override
public int getItemViewType(int position) {
   int type=0;
   if(getItem(position).isFolder())
     type=1;
   else{
     type=2;
   }
}