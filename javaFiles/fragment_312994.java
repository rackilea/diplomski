try (Scanner input = new Scanner(Paths.get(fileName))) {
    StringBuilder sb = new StringBuilder();

    while (input.hasNextLine()) {

        sb.append(input.nextLine() + "\n");

    }

    outPanel.txtOutput.setText(sb.toString());//my issue is with this line right here

} catch (IOException e) {
    e.printStackTrace();
}