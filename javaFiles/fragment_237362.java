@Override
public void onBindViewHolder(BoardComponentViewHolder holder, int  position) {
    int rowPosition = position / ITEMS_PER_ROW;
    int colPosition = position % ITEMS_PER_ROW;

    boolean isACellRow = rowPosition > 0 && rowPosition < (ITEMS_PER_ROW-1);
    boolean isACellCol = colPosition > 0 && colPosition < (ITEMS_PER_ROW-1);

    if (isACellCol && isACellRow){
        int color = (rowPosition+colPosition) % 2 == 0 ? Color.rgb(255,180, 35) : Color.rgb(128,41,21);
        holder.imageView.setBackgroundColor(color);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cellSizePx, cellSizePx);
        holder.imageView.setLayoutParams(layoutParams);
    }
    else
    {
        int cellWidth = isACellCol ? cellSizePx : cellSizePx / 2;
        int cellHeight = isACellRow ? cellSizePx : cellSizePx / 2;
        holder.imageView.setBackgroundColor(Color.rgb(191, 96, 123));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cellWidth, cellHeight);

        //Just Added three lines here..!!

        if(colPosition==0) {
            layoutParams.setMargins(cellWidth,0,0,0);
        }
        holder.imageView.setLayoutParams(layoutParams);
    }
}