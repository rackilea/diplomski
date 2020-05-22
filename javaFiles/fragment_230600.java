@Override
public void onBindViewHolder(DataObjectHolder holder, int position) {
    String[] messages = mDataset.get(position).getAllMessages(); // The method that we just code
    for(int i = 0; i < tvList.size(); i++){
        if(messages[i].isEmpty()){
            tvList.get(i).setVisibility(View.GONE);
        }else{
             tvList.get(i).setVisibility(View.VISIBLE);
             tvList.get(i).setText(messages[i]);
        }
    }
}