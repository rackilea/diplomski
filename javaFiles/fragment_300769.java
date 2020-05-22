StringBuilder stringBuilderDestinationAddr = new StringBuilder();

for (int i = 0; i < destination_addr.length(); i++)
    if (destination_addr.charAt(i) != '[' && destination_addr.charAt(i) != ']' && destination_addr.charAt(i) != '"')
         stringBuilderDestinationAddr.append(pickup_addr.destination_addr (i));

String strCleanDestination = stringBuilderDestinationAddr.toString();