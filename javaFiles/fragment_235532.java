if(holder.textViewSKSkat.getText().equals("kritis") || holder.textViewSKSkat.getText().equals("kurang")){
    holder.textViewSKSkat.setTextColor(Color.rgb(255,0,0));
    Log.d("testing", "ayayaya");
} else {
    holder.textViewSKSkat.setTextColor(Color.rgb(0,0,0)); //TODO : SET DEFAULT COLOR
}


if(holder.textViewIPKkat.getText().equals("kritis") || holder.textViewIPKkat.getText().equals("kurang")){
    holder.textViewIPKkat.setTextColor(Color.rgb(255,0,0));
    Log.d("testing", "ayayaya");
} else {
    holder.textViewIPKkat.setTextColor(Color.rgb(0,0,0)); //TODO : SET DEFAULT COLOR
}