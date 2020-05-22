Scanner scnr = new Scanner(System.in);

double [][] scores = new double[3][3];
double value = 0;

int i=0;
int j;

while (i < 3) {
    j=0;
    while (j < 3) {
        System.out.print("Enter a number: ");
        value = scnr.nextDouble();
        scores[i][j]=value;
        j++;
    }
    i++;
}