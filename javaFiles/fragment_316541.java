// Implement On Item click listener
        gridView.setOnItemClickListener(new OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {



            switch(position)
            {
            case 1:
            Intent newActivity = new Intent(GinfyActivity.this,MainActivity.class);
            startActivity(newActivity);
            break;

            case 2:
            Intent new1Activity = new Intent(GinfyActivity.this,AndroidTabLayoutActivity.class);
            startActivity(new1Activity);
            break;
            default:
                Toast.makeText(GinfyActivity.this, "Wrong Input", Toast.LENGTH_LONG).show();
                }
        }
    });