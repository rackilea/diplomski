public class ReminderListAdapter extends ArrayAdapter<Reminder> {
private Context mContext;
private int mResource;

  private final OnItemClickListener listener;

  public ReminderListAdapter(@NonNull Context context, int resource, 
  @NonNull ArrayList<Reminder> objects) {
  super(context, resource, objects);
  mContext = context;
  mResource = resource;
  }


 public setListener(final OnItemClickListener listener) {
   this.listener = listener;
 }
 ...

 @NonNull
 @Override
 public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
  ...

  delbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      listener.onItemClick(convertView, position, name);
    }
  });
  }

}