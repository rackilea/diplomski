Figure circle = new Circle();
Figure square = new Square();
circle.compareTo(square);



public int compareTo(Figure a) {
        if (this.calculatevolume() > a.calculatevolume())
            return (int)this.calculatevolume();
        else if (this.calculatevolume() < a.calculatevolume())
            return (int) a.calculatevolume();
        return 0;
    }