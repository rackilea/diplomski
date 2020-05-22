@Override
public void onBindViewHolder(final MyAdapter.MyViewHolder holder, int position) 
{
 .....
    holder.itemView.post(new Runnable()
    {
        @Override
        public void run()
        {

            int cellWidth = holder.itemView.getWidth();// this will give you cell width dynamically
            int cellHeight = holder.itemView.getHeight();// this will give you cell height dynamically

        }
    });
  .....
}