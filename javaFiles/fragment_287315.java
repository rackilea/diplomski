class Coords implements Serializable {
    int x, y;
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }       
}

...

// To write:
// oos = ObjectOutputStream of the socket
Coords tmp = new Coords(x, y);
oos.writeObject(tmp);
oos.flush();

...

//To read:
//ois = ObjectInputStream of the socket
Coords tmp = (Coords)ois.readObject();