new View.OnClickListener()
{
    EditText texEdit = findViewById(R.id.inputField);
    TextView viewText = findViewById(R.id.operatorDisplay);

    public void onClick(View view)
    {

        String content = texEdit.getText().toString();

        Matcher tigoMatcher = tigoOne.matcher(content);

        if (tigoMatcher.matches())
        {
            String message = "valid";
            viewText.setText(message);

        }else{
            String message = "not valid";
            viewText.setText(message);
        }
    }
}