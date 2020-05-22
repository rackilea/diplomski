public void login (View view){
            EditText et = (EditText) findViewById(R.id.txtUserName);
            String text= et.getText().toString();
            System.out.println("text = "+text);

            if(text.equals("User")){//if you want exact value otherwise you can use text.equalsIgnoreCase("your string")
                System.out.println("Im in if");
                Intent intent = new Intent(this, Order.class);
                startActivity(intent);

            }else if(text.equals("HOD")){

                Intent intent = new Intent(this,HOD.class);
                startActivity(intent);

            }else if(text.equals("HR")) {

                Intent intent = new Intent(this,HR.class);
                startActivity(intent);

            }else{

                System.out.println("Im in else");

            }

        }