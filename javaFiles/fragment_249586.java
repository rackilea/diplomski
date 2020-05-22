final RadioGroup group= (RadioGroup) findViewById(R.id.radioAlgorithms);
group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioaes:
                // Your code
                break;
            case R.id.radiodes:
                // Your code
                break;
            case R.id.radioidea:
                // Your code
                break;
            case R.id.radiocustom:
                // Your code
                break;
            default:
                // Your code
                break;
        }
    }
});