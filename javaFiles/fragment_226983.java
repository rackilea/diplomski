public class ViewHolder extends RecyclerView.ViewHolder {
    SwitchCompat mSwitchCompat;
    Boolean isTouched = false;

    public ViewHolder(View itemView) {
        super(itemView);
        mSwitchCompat = (SwitchCompat) itemView.findViewById(R.id.setting_channel_switch);

        mSwitchCompat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTouched = true;
                return false;
            }
        });

        mSwitchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isTouched) {
                    isTouched = false;

                    if (isChecked) {
                        click.posClicked((short)getAdapterPosition());
                    } else {
                        // Do something on un-checking the SwitchCompat
                    }
                }
            }
        });
    }
}