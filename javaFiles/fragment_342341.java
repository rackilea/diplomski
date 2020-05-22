for(int i = 0; i < tr.size(); i++)
    {
        btDec.get(i).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Log.i("ButtonListener", "test");
            }
        });
    }