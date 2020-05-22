public static void main(String[] args) {
    Random randomGenerator = new Random();
    int n = randomGenerator.nextInt(1000);

    StringBuilder output = new StringBUilder("The randomly generated number was: " + n + "\n");

    while(n > 1){
        if(n % 2 == 0){
            n = n / 2;
        }
        else{
            n = 3 * n + 1;
        }
        output.append(n + "\n");
    }

    output.append("Done.");
    JOptionPane.showMessageDialog(null, output);

}