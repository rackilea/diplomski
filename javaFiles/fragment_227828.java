public static void main(String[] args) {
    final int MAX_ON_LIST = 50;
    final int bottomCreditsLimit = 30;
    final int topCreditsLimit = 90;

    String[] stuName = new String[0];
    int[] numCredits = new int[0];

    String question = JOptionPane.showInputDialog("Are you done entering students? (Enter 'Y' or 'N')");

    while (question.equalsIgnoreCase("n") && stuName.length < MAX_ON_LIST) {
        String stuNameInput = "";
        do {
            stuNameInput = JOptionPane.showInputDialog("Enter student name:").trim();
            if (stuNameInput.equals("")) {
                JOptionPane.showMessageDialog(null, "Name cannot be blank");
            }
        } while (stuNameInput.equals(""));

        int numCreditsInput = -1;
        do {
            try {
                numCreditsInput = Integer.parseInt(JOptionPane.showInputDialog("Enter # of completed credits:").trim());
                if (numCreditsInput < 0) {
                    JOptionPane.showMessageDialog(null, "# of credits can't be less than 0");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please input integer value");
            }
        } while (numCreditsInput < 0);

        if (numCreditsInput >= bottomCreditsLimit && numCreditsInput <= topCreditsLimit) {
            stuName = Arrays.copyOf(stuName, stuName.length + 1);
            stuName[stuName.length - 1] = stuNameInput;
            numCredits = Arrays.copyOf(numCredits, numCredits.length + 1);
            numCredits[numCredits.length - 1] = numCreditsInput;
            JOptionPane.showMessageDialog(null, Arrays.toString(stuName) + "\n" + Arrays.toString(numCredits));
        }

        question = JOptionPane.showInputDialog("Are you done entering students? (Enter 'Y' or 'N')");
    }

    String nxtQuestion = JOptionPane.showInputDialog("Are you done with the admin. review? (Enter 'Y' or 'N')");

    while (nxtQuestion.equalsIgnoreCase("n")) {
        String searchValue = JOptionPane.showInputDialog("Enter a name:").trim();
        int position = -1;

        for (int i = 0; i < stuName.length; i++) {
            if (stuName[i].equalsIgnoreCase(searchValue)) {
                position = i;
                break;
            }
        }
        if (position >= 0) {
            stuName[position] = stuName[stuName.length - 1];
            stuName = Arrays.copyOf(stuName, stuName.length - 1);
            numCredits[position] = numCredits[numCredits.length - 1];
            numCredits = Arrays.copyOf(numCredits, numCredits.length - 1);
        } else {
            JOptionPane.showMessageDialog(null, "Name not on list");
        }
        JOptionPane.showMessageDialog(null, Arrays.toString(stuName) + "\n" + Arrays.toString(numCredits));

        nxtQuestion = JOptionPane.showInputDialog("Are you done with the admin. review? (Enter 'Y' or 'N')");
    }

    JOptionPane.showMessageDialog(null, "Report Header\n\n" + "# of student's on list: " + stuName.length + "\nNames: " + Arrays.toString(stuName)
            + "\nCredits: " + Arrays.toString(numCredits));
}