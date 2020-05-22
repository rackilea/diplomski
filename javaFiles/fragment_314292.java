public class MealAdapter extends BaseAdapter{
    private int  mHour, mMinute;
     int minutes,hour;
       String strtime;
    customButtonListener customListner; 
    private Context context;
    private List<Meal> rowItems;

    public MealAdapter(Context context, List<Meal> rowItems) {

        this.context = context;
        this.rowItems = rowItems;
    }

     @Override
     public int getCount() {
      return rowItems.size();
     }

     @Override
     public Object getItem(int position) {
      return rowItems.get(position);
     }

     @Override
     public long getItemId(int position) {
      return rowItems.indexOf(getItem(position));
     }
    private class OptionHolder
    {

        ImageButton btn_time;
        ImageButton btn_delete;
    }


    @Override
    public View getView(final int position,  View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
         final OptionHolder holder;


         if (convertView == null) 
          {
             LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

           convertView = mInflater.inflate(R.layout.meal_list_item, null);
           holder = new OptionHolder();

           holder.btn_time= (ImageButton) convertView.findViewById(R.id.btn_time);
           holder.btn_delete =(ImageButton) convertView.findViewById(R.id.btn_delete_meal);

           convertView.setTag(holder);


           }
          else
          {
              holder = (OptionHolder) convertView.getTag();
          }
         final Meal row_pos=rowItems.get(position);
           row_pos.setMeal("");
           row_pos.setDetail("");
           holder.ed_meal.setText(row_pos.getMeal());
           holder.ed_detail.setText(row_pos.getDetail());
           holder.ed_time.setText(row_pos.getTime());

       holder.btn_time.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub

            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog tpd = new TimePickerDialog(MealPlannerFragment.con,
                    new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay,
                        int minute) {
                    // Display Selected time in textbox
                    strtime=(hourOfDay + ":" + minute);

                    row_pos.setTime(strtime);

                    row_pos.setMunite(minute);
                    row_pos.setHour(hourOfDay);
                    holder.ed_time.setText(row_pos.getTime());
                    }
            }, mHour, mMinute, false);
    tpd.show();

    }
    });
       holder.btn_delete.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            if (customListner != null) {  
                customListner.onButtonClickListner(position,row_pos);  
            }  
        }
    });

          return convertView;
}
     public interface customButtonListener {  
            public void onButtonClickListner(int position,Meal row_pos);  
        }  
     public void setCustomButtonListner(customButtonListener listener) {  
            this.customListner = listener;  
        }  

}
`