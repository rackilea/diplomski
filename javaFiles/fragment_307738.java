VGMO1.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            String ViewID = getResources().getResourceName(view.getId());
            IDfinal = cutID(ViewID);

            Log.d(TAG, "" + IDfinal);

            Intent intent = new Intent(getActivity(), StundeZuweisen.class);
            intent.putExtra("ViewID", IDfinal);

            startActivityForResult(intent, 0);
            return true;
        }
    });


@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode == Activity.RESULT_OK && requestCode == 0){
        String arr[] = data.getStringArrayExtra("result");
        schreibeInTV(arr[0],arr[1],arr[2]);
    }
}