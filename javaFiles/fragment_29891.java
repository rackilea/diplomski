if ("6".equals(holder.tvPosisie.getText().toString())) {
    holder.itemView.setBackgroundColor(Color.RED);
} else if("7".equals(holder.tvPosisie.getText().toString())) {
    holder.itemView.setBackgroundColor(Color.YELLOW);
} else if ("4".equals(holder.tvPosisie.getText().toString())) {
    holder.itemView.setBackgroundColor(Color.BLUE);
} else { 
    holder.itemView.setBackgroundColor(Color.WHITE);
}