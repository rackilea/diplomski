holder.rmv_img.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    dbHelper = new DBHelper(context);
                    try {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        db.delete(User_Detail.TABLE_4, User_Detail.KEY_ID_ALBUM_IMAGE + " ='" + img_list.get(position).getId_() + "'", null);
                        img_list.remove(position);
                        notifyDataSetChanged();
                        popupWindow.dismiss();
                        holder.rmv_img.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });