class Surprise {
    String item;
    public Surprise(String item) {
        this.item = item;
    }
    //this is called copy constructor
    //because you receive an object from the same class
    //and copy the values of the fields into the current instance
    //this way you can have a "copy" of the object sent as parameter
    //and these two object references are not tied by any mean
    public Surprise(Surprise another) {
        //here you just copy the value of the object reference of another#item
        //into this#item
        this.item = another.item;
    }
}

class Box {
    Surprise surprise;
    public Box(Surprise surprise) {
        //here you create a totally new instance of Surprise
        //that is not tied to the parameter surprise by any mean
        this.surprise = new Surprise(surprise);
    }

    public static void main(String[] args) {
        Surprise surprise1 = new Surprise("1");
        Surprise surprise2 = new Surprise("2");
        Box[] boxes = {
            new Box(surprise1),
            new Box(surprise1),
            new Box(surprise2),
            new Box(surprise2)
        };
        boxes[0] = boxes[3];
        //you update surprise1 state
        //but the state of Box#surprise in the boxes that used surprise1
        //won't get affected because it is not the same object reference
        surprise1.item = "3";
        //print everything...
        System.out.println("Boxes full of surprises");
        //this code does the same as the printing above
        for (Box box : boxes) {
            System.out.print(box.surprise.item);
        }
        System.out.println();
    }
}