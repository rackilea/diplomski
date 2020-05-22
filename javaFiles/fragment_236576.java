public Dice(int dice1){
    this.dice1 = dice1; }
public int getDice1(){
    return dice1;
}
public void countNumbers(){     
    if (dice1 == 1){
        a++;
    }
    else if(dice1 == 2){
        b++;
    }
    else if(dice1 == 3){
        c++;
    }
    else if(dice1 == 4){
        d++;
    }
    else if(dice1 == 5){
        e++;
    }
    else if(dice1 == 6){
        f++;
    }
}

public void saveResults() {
    sa += a;
    sb += b;
    sc += c;
    sd += d;
    se += e;
    sf += f;
}

public static void displayResults() {
    System.out.println(sa + " " + sb + " " + sc + " " + sd + " " + se + " " + sf);
} }