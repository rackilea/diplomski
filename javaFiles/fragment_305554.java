public class MyStocksAdapter extends ArrayAdapter<StockList>{
private List<StockList> stocksList;
private RoundImage roundedImage;

public MyStocksAdapter(Context context, int resource, List<StockList> objects) {
    super(context, resource, objects);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View stockView = li.inflate(R.layout.list_item, parent, false);
        StockList current = getItem(position);

        if(current != null){
            TextView stockName = (TextView)stockView.findViewById(R.id.stock_name);
            stockName.setText(current.getStockCurrentName());


            TextView stockPrice = (TextView)stockView.findViewById(R.id.stock_price);
            stockPrice.setText(current.getStockCurrentPrice());

            ImageView stockImage = (ImageView)stockView.findViewById(R.id.imagestartinglist);
            stockImage.setImageBitmap(current.getStockImage());
        }
    return stockView;
}
}