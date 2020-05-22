View myView = inflater.inflate(R.layout.first_layout, container, false);
 RadioGroup radioGroup = (RadioGroup) myView.findViewById(R.id.radio);        
radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
{
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // checkedId is the RadioButton selected
         switch(checkedId){
                case R.id.radioGram:
                    // do operations specific to this selection
                    Toast.makeText(getActivity(),"Gram selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioKilogram:
                    // do operations specific to this selection
                    Toast.makeText(getActivity(),"KiloGram selected", Toast.LENGTH_SHORT).show();
                    break;
            }  
    }
});