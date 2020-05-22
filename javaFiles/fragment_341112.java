@Override
public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getPhoto());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                    Intent intent;
                    switch (position) {
                        case 0:
                            intent = new Intent(mContext, pdfone.class);
                            mContext.startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(mContext, pdftwo.class);
                            mContext.startActivity(intent);
                            break;
                        ...
                        //do the same for every card possible
                   } 
                 }

}