public class myAdapter extends ArrayAdapter implements View.OnClickListener{
    HashMap<int, String> mMap;

    public myAdapter(){
        mMap = new HashMap<int, String>;
    }

    @Override
    public View getView(int position, View view, ViewGroup container){
        // initialize view . . .
        . . .

        Button callB = (Button)  convertView.findViewById(R.id.bCall);
        callB.setOnClickListener(this);
        mMap.put(callB.getId(), "phone-number-goes-here");

        . . .
    }

    @Override
    public void onClick(View v){
        if (mMap.containsKey(v.getId())){
            getActivity().startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mMap.get(v.getId())));
        }

    }

}