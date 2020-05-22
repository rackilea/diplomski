public class DeviceRecyclerView extends RecyclerView.Adapter<DeviceRecyclerView.ViewHolder> {

private ArrayList<Device> deviceList;
public DeviceRecyclerView(Arraylist<Device> deviceList){
    this.deviceList= deviceList;

}
@Override
public DeviceRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.device_list_row, parent , false);
    return new ViewHolder(view);
}

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    Device device = deviceList.get(position);

    holder.deviceNameTextView.setText(device.getName());
    holder.deviceUUIDTextViewValue.setText(device.getUuid());
    holder.deviceRSSIVTextViewValue.setText(device.getRssi());



}

@Override
public int getItemCount() {
    return deviceList.length;
}

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView deviceNameTextView, deviceUUIDTextViewValue, deviceRSSIVTextViewValue;

    public ViewHolder(View itemView)  {

        super(itemView);
        itemView.setOnClickListener(this);
        deviceNameTextView = itemView.findViewById(R.id.DeviceNameTextView);
        deviceUUIDTextViewValue = itemView.findViewById(R.id.DeviceUUIDTextViewValue);
        deviceRSSIVTextViewValue = itemView.findViewById(R.id.DeviceRSSIVTextViewValue);
    }

    @Override
    public void onClick(View v) {
        Log.i("DEBUG","Item RecyclerView Cliqué");
    }
}