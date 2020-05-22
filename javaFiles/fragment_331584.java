@Override
public int getItemViewType(int position) 
{
    if (position % 5 == 0){
        return AD_TYPE; 
    }else{
        return CONTENT_TYPE;
    }
}