@Override
public void onBindViewHolder(CustomViewHolder holder, int position) {

if (position != subTypes.size()) {
    SubType subType = subTypes.get(position);
    holder.tvProductName.setText(subType.name);
    Picasso.with(context).load(subType.image).into(holder.ivProduct);
    if (!subType.disc.equals("0")) {

        holder.tvDiscountPercentage.setText(subType.disc + "%");
        holder.tvActualAmount.setPaintFlags(holder.tvActualAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        int a = Integer.parseInt(subType.amount);
        float b = Float.parseFloat(subType.disc) / 100;
        holder.tvActualAmount.setText("₹ " + subType.amount);
        int c = (int) (a * b);
        holder.tvDiscountAmount.setText("₹ " + c);
    } else {
            holder.tvDiscountPercentage.setBackgroundColor(Color.parseColor("#ffffff"));
        holder.tvActualAmount.setText("₹ " + subType.amount);
    }
} else {
    holder.seeMore.setText("See More >>");
}
}