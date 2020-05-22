import java.util.Random;

ArrayList<int[]> fields = new ArrayList<int[]>();

PGraphics board;

void setup()
{
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


    size(700, 700);  
    board = createGraphics(700, 700);
    board.beginDraw();

    board.background(205,230,208);

    // four squares on each corner
    board.strokeWeight(4);
    board.stroke(0);
    board.noFill();

    for(int[] f : fields) {
        board.rect(f[0], f[1], f[2], f[3]);
    }   

    //inside square + lines for chance
    board.rect(125, 125, 450, 450);
    board.rect(0, 0, 700, 700); 

    board.line(0, 305, 125, 305);
    board.line(575, 395, 700, 395);
    board.line(305, 575, 305, 700);
    board.line(395, 0, 395, 125);

    // green
    board.fill(30, 178, 90);
    board.rect(125, 90, 90, 35); 
    board.rect(215, 90, 90, 35); 
    board.rect(485, 90, 90, 35); 

    // yellow
    board.fill(253, 241, 1);
    board.rect(90, 125, 35, 90); 
    board.rect(90, 395, 35, 90); 
    board.rect(90, 485, 35, 90);

    //red
    board.fill(224, 25, 33);
    board.rect(575, 125, 35, 90); 
    board.rect(575, 215, 35, 90); 
    board.rect(575, 485, 35, 90);

    // blue
    board.fill(172, 223, 252);
    board.rect(125, 575, 90, 35); 
    board.rect(395, 575, 90, 35); 
    board.rect(485, 575, 90, 35); 

    //logo
    PFont comic;
    PFont taxandchance = createFont("ComicSansMS", 75);
    board.fill (237, 27, 35); 
    comic = createFont("ComicSansMS", 45);
    board.textFont(comic);

    board.pushMatrix();
    board.translate(215,490);
    board.rotate(radians(315));
    board.translate(-215,-490);
    board.text("Mini Monopoly TM", 215, 490);
    board.popMatrix();

    // go
    int x = 615;
    int y = 670;
    board.pushMatrix();
    board.fill(0);
    board.translate(x,y);
    board.rotate(radians(315));
    board.translate(-x,-y);
    board.text("GO", x, y);
    comic = createFont("ComicSansMS", 18);
    board.textFont(comic); 
    board.text("collect $200", x-14, y+25); 
    board.popMatrix();

    PFont corner = createFont("ComicSansMS", 35);
    // free parking
    x = 50;
    y = 100;
    board.pushMatrix();
    board.fill(0);
    board.translate(x,y);
    board.rotate(radians(315));
    board.translate(-x,-y);
    board.textFont(corner);
    board.text("Free", x, y);
    board.popMatrix();

    // stillwells
    x = 600;
    y = 40;
    board.pushMatrix();
    PFont stillwells = createFont("ComicSansMS", 25);
    board.textFont(stillwells);
    board.fill(0);
    board.translate(x,y);
    board.rotate(radians(45));
    board.translate(-x,-y);
    board.text("Stillwells", x, y);
    board.popMatrix();

    // grill
    x = 38;
    y = 620;
    board.pushMatrix();
    board.fill(0);
    board.translate(x,y);
    board.rotate(radians(45));
    board.translate(-x,-y);
    board.textFont(corner);
    board.text("Grill", x, y);
    board.popMatrix();

    // location names bottom row
    board.fill (0); 
    board.textFont(comic);
    board.text("Library", 500, 650);
    board.text("$100", 500, 680);
    board.text("Elm", 425, 650);
    board.text("$100", 418, 680);
    board.text("Weth", 145, 650);
    board.text("$120", 145, 680);
    board.text("Train", (325), 620);
    board.text("station:", (325), 640);
    board.text("Andover", (320), 660);
    board.textFont(taxandchance);
    board.fill(0, 175,237);
    board.text("$", 236, 668);

    // location names top row

    x = 198;
    y = 55;
    board.pushMatrix();
    board.fill(0);
    board.textFont(comic);
    board.translate(x,y);
    board.rotate(radians(180));
    board.translate(-x,-y);
    board.text("Bowld", x, y);
    board.text("PHLH", x - 90, y);
    board.text("ACB", x - 350, y);
    board.text("$260", x, y+30);
    board.text("$260", x - 90, y+30);
    board.text("$280", x - 350, y+30);
    board.text("Train", x - 182, y-25);
    board.text("station:", x - 189, y-5);
    board.text("Hotchkiss", x - 195, y+25);
    board.textFont(taxandchance);
    board.fill(0, 175,237);
    board.text("$", x-261, y+20);

    board.popMatrix();

    // locationnames yellow
    x = 60;
    y = 511;
    board.pushMatrix();
    board.textFont(comic);
    board.fill(0);
    board.translate(x,y);
    board.rotate(radians(90));
    board.translate(-x,-y);
    board.text("HR", x, y);
    board.text("OMA", x - 90, y);
    board.text("Bissell", x -364, y);
    board.text("$180", x, y+30);
    board.text("$180", x - 90, y+30);
    board.text("$200", x - 360, y+30);
    board.text("Train", x - 182, y-25);
    board.text("station:", x - 189, y-5);
    board.text("Choate", x - 186, y+25);
    board.textFont(taxandchance);
    board.fill(247,134,32);
    board.text("?", x-270, y+25); 
    board.popMatrix();

    // locationnames red
    x = 640;
    y = 190;
    board.pushMatrix();
    board.textFont(comic);
    board.fill(0);
    board.translate(x,y);
    board.rotate(radians(270));
    board.translate(-x,-y);
    board.text("Phelps", x-5, y);
    board.text("Field H.", x - 100, y);
    board.text("Goel", x -363, y);
    board.text("$320", x, y+30);
    board.text("$350", x - 90, y+30);
    board.text("$400", x - 370, y+30);
    board.text("Train", x - 182, y-25);
    board.text("station:", x - 189, y-5);
    board.text("Deerfield:", x - 200, y+25);

    board.textFont(taxandchance);
    board.fill(247,134,32);
    board.text("?", x-270, y+25);
    board.popMatrix();

    board.endDraw();
}

int pos_l = 0;
int pos_a = 0;

void draw(){
    image(board, 0, 0); 

    // tokens

    int xl = fields.get(pos_l)[0] + fields.get(pos_l)[2] / 3;
    int yl = fields.get(pos_l)[1] + fields.get(pos_l)[3] / 3;
    fill(226, 53, 143); 
    ellipse(xl, yl, 30, 30);

    int xa = fields.get(pos_a)[0] + fields.get(pos_a)[2] * 2 / 3;
    int ya = fields.get(pos_a)[1] + fields.get(pos_a)[3] * 2 / 3;
    fill(1, 110, 203); 
    ellipse(xa, ya, 30, 30);  
}

int p1position = 0; 
int p2position = 0; 
int p1diceroll;
int p2diceroll;
String name1 = "Jasmine";
String name2 = "Iliana"; 

void keyPressed(){

    Random rand = new Random();

    if (key == 'l'){
        // Obtain a number between [0 - 5].
        p1diceroll = rand.nextInt(6) + 1;
        println("You rolled a " + p1diceroll + "!"); 
        println(name2 + " press 'a' to roll");

        pos_l = (pos_l + p1diceroll) % fields.size();
    }

    if (key == 'a'){

        // Obtain a number between [0 - 5].
        p2diceroll = rand.nextInt(6) + 1;
        println("You rolled a " + p2diceroll + "!");  
        if (p1diceroll>p2diceroll){
            System.out.println(name1 + " rolled higher!. They go first.");
        }
        if (p2diceroll>p1diceroll){
            System.out.println(name2 + " rolled higher!. They go first. "); 
        }
        if (p2diceroll==p1diceroll){
            System.out.println("It's a tie! " + name1 + " goes first by default." ); 
        }

        pos_a = (pos_a + p2diceroll) % fields.size();
    }
}