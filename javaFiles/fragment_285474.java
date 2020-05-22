if(p1 > p2 && p1 > p3 && p1 > p4){
            Toast.makeText(getApplicationContext(), p1 + " You chose the winner!",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), p1 + " It's a tie.",
                    Toast.LENGTH_SHORT).show();    
        }