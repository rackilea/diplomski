btnFind.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            try
            {
                int a = Integer.valueOf(txtNum.getText().toString());
                int b = Integer.valueOf(txtFriend.getText().toString());                
                txtNum.setVisibility(View.GONE);

                if (b == a + 25 || a == a - 25)
                {
                    txtTry.setText("Cold");
                }
                else if (b == a + 10 || b == a - 10)
                {
                    txtTry.setText("Hot");
                }
                else if (b == a)
                {
                    txtTry.setText("Your friend number is: " + b);
                }
            }
            catch (NumberFormatException e)
            {
                txtTry.setText("Invalid input.");
            }
        }
    }
);