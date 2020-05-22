ArrayList<int[]> fields = new ArrayList<int[]>();

void setup() {

    // bottom right
    fields.add(new int[]{575, 575, 125, 125});

    // squares bottom side
    for (int i=4; i>=0; i--){
        fields.add(new int[]{125+(i*90), (i==1 || i==2) ? 575 : 610, 90, (i==1 || i==2) ? 125 : 90});
    }

    // bottom left
    fields.add(new int[]{0, 575, 125, 125});

    // squares left side
    for (int i=4; i>=0; i--){
        fields.add(new int[]{0, 125+(90*i), (i==1 || i==2) ? 125 : 90, 90});
    }

    // top left
    fields.add(new int[]{0, 0, 125, 125});

    // squares top side
    for (int i=0; i<5; i++){
       fields.add(new int[]{125+(i*90), 0, 90, (i==2 || i==3) ? 125 : 90});
    }

    // top right
    fields.add(new int[]{575, 0, 125, 125});

    // squares right side
    for (int i=0; i<5; i++){
        fields.add(new int[]{(i==2 || i ==3) ? 575 : 610, 125+(90*i), (i==2 || i ==3) ? 125 : 90, 90});
    }

    // [...]

}