public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView amount;
        TextView expense;
        ImageView small;
        ImageView big;

        ItemViewHolder(View itemView, int viewType) {
            super(itemView);
            amount = (TextView) itemView.findViewById(R.id.txtAmount);
            expense = (TextView) itemView.findViewById(R.id.txtexpense);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            small = (ImageView) itemView.findViewById(R.id.small);
            big=(ImageView)itemView.findViewById(R.id.big);
            //   cv1 = (CardView) itemView.findViewById(R.id.card_view);

            //TextDrawable drawable1 = TextDrawable.builder()
            // .buildRound("20 Jan", Color.RED);

        }
    }