// change the constructor of Customer
public Customer(String name, int room) {
    this.name = name;
    this.room = room;
}

// change the toString() of Customer
public String toString() {
    return String.format("customer: %s  room: %d", name, room);
}

// store the Customer like
customers[roomNum] = new Customer(input.next().toLowerCase(), roomNum);