String[] types = new String[roomcount];
    for(int i = 0; i < types.length; i++) {
        System.out.print ("Please enter the types of room " + places[i]);
        String roomName = sc.next();
        types[i] = roomName;
        System.out.println("Room name: " + roomName);
    }