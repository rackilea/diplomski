SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
int start = sharedPref.getInt("firstRunDate", 0);
   Calender cal = Calendar.getInstance();
    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)+1;

if((dayOfMonth+15)%30 == start)
//send notifications