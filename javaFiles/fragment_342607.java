import java.util.Random;

public class NightSky {

private double density;
private int width;
private int height;
private int starsInLastPrint;

public static void main(String[] args){

    NightSky sky = new NightSky(5,5);
    sky.print();
    System.out.println(sky.starsInLastPrint());

    sky.print();
    System.out.println(sky.starsInLastPrint());
}


public NightSky(double density) {
    width = 20;
    height = 10;
    this.density = density;
}

public NightSky(int width, int height) {
    density = 0.1;
    this.width = width;
    this.height = height;

}

public NightSky(double density, int width, int height) {
    this.density = density;
    this.width = width;
    this.height = height;
}

public void printLine() {
    Random starPlacement = new Random();
    String[] stars = new String[(this.width)];

    for (int i = 0; i < this.width; i++) {
        double random = starPlacement.nextDouble();
        if (random <= this.density) {
            stars[i] = "*";
            this.starsInLastPrint++;
        } else {
            stars[i] = " ";
        }
    }

    int j = 0;
    while (j < stars.length) {
        System.out.print(stars[j]);
        j++;

    }
    System.out.println("");

}

public void print() {
    this.starsInLastPrint = 0;
    int i=0;
    while (i < this.height) {
        printLine();
        i++;
    }

}

public int starsInLastPrint() {

    return this.starsInLastPrint;

}

}