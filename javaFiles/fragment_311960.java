@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Make sure we have a view to work with (may have been given null)
        Log.d("Position:", " "+position);
        View itemView   =   convertView;

        if(itemView ==  null){
            itemView =  getLayoutInflater().inflate(R.layout.item_view, parent,false);
        }

        //find the Car to work with
        Restaurant restaurantGetSetData=restaurantList.get(position);

        ImageView restaurantImage_restList_iv=(ImageView)itemView.findViewById(R.id.restaurantImage_restList_iv); 
        restaurantImage_restList_iv.setImageResource(restaurantGetSetData.getIconID());

        TextView restaurantName_restList_tv=(TextView)itemView.findViewById(R.id.restaurantName_restList_tv);
        restaurantName_restList_tv.setText(restaurantGetSetData.getRestaurantName()+"count:"+count++);

        TextView restaurantCusine_restList_tv=(TextView)itemView.findViewById(R.id.restaurantCusine_restList_tv);
        restaurantCusine_restList_tv.setText(restaurantGetSetData.getRestaurantCusine());

        TextView restaurantLocation_restList_tv=(TextView)itemView.findViewById(R.id.restaurantLocation_restList_tv);
        restaurantLocation_restList_tv.setText(restaurantGetSetData.getRestaurantLocation());   


        TextView restaurantRating_restList_tv=(TextView)itemView.findViewById(R.id.restaurantRating_restList_tv);
        restaurantRating_restList_tv.setText(restaurantGetSetData.getRating());
        String rate=restaurantGetSetData.getRating();
        restaurantRating_restList_tv.setBackgroundColor(Color.parseColor("#"+ArrayColor[(int) Float.parseFloat(rate)]));



        //-----------------------slot and offer--------------------------------------------------

        Typeface typeface = Typeface.createFromAsset(getBaseContext().getAssets(),
                "helvetica_reg.ttf");
      LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,      
                LayoutParams.WRAP_CONTENT
        );
      LayoutParams layout=new LayoutParams(LayoutParams.WRAP_CONTENT,      
                LayoutParams.WRAP_CONTENT);
            layout.setMargins(5, 0, 5, 0);
            params.setMargins(0, 10, 0, 10);
        LinearLayout rl=(LinearLayout)itemView.findViewById(R.id.restaurantSlotOffer_restList_tv);


rl.removeAllViews();//<------------------------------------------

        for(int j=0;j<8;j++)
        {
            LinearLayout l=new LinearLayout(getApplicationContext());
            l.clearDisappearingChildren();
            l.setLayoutParams(layout);
            l.setOrientation(LinearLayout.VERTICAL);
            TextView time=new TextView(getApplicationContext());
            time.setBackgroundColor(getResources().getColor(R.color.out_gray));
            time.setTextColor(Color.BLACK);
            time.setTextSize(getApplicationContext().getResources().getDimensionPixelSize(R.dimen.custom_text_size));
            time.setGravity(Gravity.CENTER);
            time.setLayoutParams(new LayoutParams(90, LayoutParams.WRAP_CONTENT));
            time.setPadding(2,2,2,2);
            View v1=new View(getApplicationContext());
            v1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 1));
            v1.setBackgroundColor(color.white);
            TextView deal=new TextView(getContext());
            deal.setLayoutParams(new LayoutParams(90, LayoutParams.WRAP_CONTENT));
            deal.setGravity(Gravity.CENTER);
            deal.setTextSize(getApplicationContext().getResources().getDimensionPixelSize(R.dimen.custom_text_size));
            deal.setPadding(2,2,2,2);
            deal.setTextColor(getResources().getColor(R.color.our_red));
            deal.setBackgroundColor(getResources().getColor(R.color.out_gray));
            time.setTypeface(typeface);  

            //Log.d("slot from info anshul:", slot.get(j)+"\n");
            //time code
            /*{
                String hour=slot.get(j).substring(0, 2);
                String min=slot.get(j).substring(3,5);
                if(hour.equals("--")){
                    Log.d("hour is ", "-------");
                    time.setText("--:--");
                }else{
                    int hourInt=Integer.parseInt(hour);
                    int minInt=Integer.parseInt(min);
                    hour=String.format("%d:%02d", ((hourInt==0||hourInt==12)?12:hourInt%12),minInt);
                    Log.d("correct Time", hour);
                    time.setText(hour);
                }
                Log.d("hour:", hour);
                Log.d("min:",min);
            }
            deal.setText(offer.get(j));
            deal.setTypeface(typeface);*/

            //--remove this-----------------------
            time.setText("0:0"+j);
            //deal.setText("--");

            //-----------------------------------
            l.addView(time);
            l.addView(v1);
            //l.addView(deal);
            rl.addView(l);                  
        }

        //----------------------------------------------------------------------------------------


        return itemView;

    }