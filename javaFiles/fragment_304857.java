if (dayOfNotification.after(expirationDateDt)){
             viewHolder.itemView.setBackgroundColor(resources.getColor(R.color.background_expired_products));
    }
else{
  viewHolder.itemView.setBackgroundColor(resources.getColor(R.color.background_not_expired_products));
          //for not expired item color as background_not_expired_products
 }
if (multiSelectList.contains(productList.get(position))) {
                viewHolder.itemView.setBackgroundColor(resources.getColor(R.color.background_product_selected));
 Log.d(String.valueOf(productList.get(position).getId()), productList.get(position).getName());
            }
else{
    viewHolder.itemView.setBackgroundColor(resources.getColor(R.color.background_product_not_selected));
    //say background_product_not_selected as your color for not selected item

    }