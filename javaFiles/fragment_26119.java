public void addRoom(Room room){
       if(this.rooms == null){
           this.rooms = new ArrayList<Room>();
       }
       room.setAddress(this);
       this.rooms.add(room);
  }