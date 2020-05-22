@Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

         switch (v.getId()) {
            case R.id.menu_legalnotes:

                Intent intent = new Intent(MainActivity.this, Your_SecondActivity.class);
                startActivity(intent);
                break;


            case R.id.secondButtonID:
                Intent intent = new Intent(MainActivity.this, Your_AnotherActivity.class);
                startActivity(intent);
                break;
         //You can add more cases here depending on what you want to achieve.

            default:
                break;
            }

    }