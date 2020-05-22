if (actionOne == 1) {
        System.out.println(getActionMessage1());
        actionTwo = keyboard.nextInt();
        if (actionTwo == 1) {
            System.out.println(getActionMessage1_1());
        } else if (actionTwo == 2) {
            System.out.println(getActionMessage1_2());
        }
    } else ...

public String getActionMessage1() {
    return "The long string now is not making your logic with decisions hard to understand" +
           "and it's easy to change the messages without affectiong your code logic"
}