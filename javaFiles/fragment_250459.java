public class Round {

int process = 0;
// DON'T create the array yet!
// You don't know how big to make it (yet).
// Until you ask how many processes there are
int[] processvalue;
Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    Round r = new Round();
    r.input();
    r.loop();
    r.print();
}

void input() {

    System.out.print("how many process");
//      n=Integer.parseInt(br.readLine());
    process = sc.nextInt();
    // HERE is where you now must create the array
    // Now that you know how large to make it 
    processvalue = new int[process];
}

void loop() {

    for (int i = 0; i < process; i++) {
        System.out.println("please input the process " + (i + 1));
        processvalue[i] = sc.nextInt();
    }
}

void print() {

    for (int k = 0; k < process; k++) {
        System.out.println("value" + processvalue[k]);
    }

}

}