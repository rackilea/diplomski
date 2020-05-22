int total_price = 0 ;
private void UpdatePrice(boolean incremental,int value){
    if (incremental){
        total_price = total_price + value;
        Toast.makeText(this, String.valueOf(total_price), Toast.LENGTH_SHORT).show();
    }else {
        total_price = total_price - value;
        Toast.makeText(this, String.valueOf(total_price), Toast.LENGTH_SHORT).show();
    }
}