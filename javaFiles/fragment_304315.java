int cnt = 0;

while(cnt < 4){
    size = sc.next();
    if ( size.equalsIgnoreCase( "Pepperoni") || size.equalsIgnoreCase( "Fungi" )  || size.equalsIgnoreCase( "pineapple" ) || size.equalsIgnoreCase( "bacon" )) {
        toppings.add(size);
        cnt++;
    } else if( size.equalsIgnoreCase( "done" ) ){
        break;
    }   
    else{
        System.out.print("Choose either 'Pepperoni', 'Fungi', 'bacon' or 'pineapple' Toppings, type 'done' when finshed: ");
    }
}