articleURL[i].setTag(i);
articleURL[i].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        System.out.println ( ((TextView) v).getText().toString() );
        Intent i = new Intent(getActivity().getBaseContext(), WebViewing.class);
        i.putExtra("sourceURL", ((TextView) v).getText().toString());
        i.putExtra("source" , ((TextView) source[Integer.parseInt(v.getTag())]).getText().toString());
        startActivity(i);
    }
});