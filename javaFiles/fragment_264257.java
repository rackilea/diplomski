Switch switchView = (Switch) rowView.findViewById(R.id.switch1);
    switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b)
        {
            Toast.makeText(getContext(),"Switch is" + (b?" ":" not ") + "checked",Toast.LENGTH_LONG).show();
        }
    });