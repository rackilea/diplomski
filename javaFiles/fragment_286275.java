String user_bal = (String) dataSnapshot.child("balance").getValue();
    int userBalance = Integer.parseInt(user_bal);

    if (userBalance  <= lim){
        // do something
    Toast.makeText(PostActivity.this, " NOt enough balance", Toast.LENGTH_LONG).show(); 


    }else{
       // do something
    Toast.makeText(PostActivity.this, user_bal, Toast.LENGTH_LONG).show()

    }