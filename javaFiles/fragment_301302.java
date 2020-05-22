private static ListView listView;
    listView = (ListView) findViewById(R.id.listView);

listView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
                Intent intent = null;
            switch(position){
            case 0:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            case 1:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            case 2:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            case 3:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            case 4:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            case 5:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            default:
                intent = new Intent(getApplicationContext(), AClassName.class);
                break;
            }

            if(intent != null){
                startActivity(intent);
            }

        }
    });