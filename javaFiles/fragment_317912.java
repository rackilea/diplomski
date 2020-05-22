public class listAlarmFragment extends Fragment{

  //public View view = null; // no need
  private LinearLayout baseList; 
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle bundle){
     View v = inflater.inflate(R.layout.list_alarm,vg,false);
     baseList = (LinearLayout) v.findViewById(R.id.baseList);
     //view = v; no need
     return v;
  }


   public void showAlarm(Cursor c){
     if(baseList!=null){
     //do something with your baseList 
     }
   }
 }