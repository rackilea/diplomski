rg  = (RadioGroup) findViewById(R.id.gender_ip);
rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) 
    {
         int id = rg.getCheckedRadioButtonId();
         switch (id) {
             case R.id.f:
                radioText = "Female";
                break;
            case R.id.m:
                radioText = "Male";
                break;
            default:
                // Your code
                break;
        }
    }
});