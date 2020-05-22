public class YourAdapter extends ArrayAdapter<BluetoothDevice> {
   ArrayList<BluetoothDevice> devices;
   //other stuff
 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
   //get view and the textView to show the name of the device
   textView.setText(devices.get(position).getName());
   return view;
 }
}