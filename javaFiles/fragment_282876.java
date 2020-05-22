weightPicker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
{
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        weightValue = Integer.parseInt(enterWeight.getText().toString());
        switch (checkedId) {

        case R.id.radKG:
            convertedWeight = weightValue / 2.2;
            measurement = " Kilograms";
            break;
        case R.id.radLB:

            convertedWeight = weightValue * 2.2;
            measurement = " Pounds";
            break;

    }
});