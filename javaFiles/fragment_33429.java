import java.util.Scanner;

public class PictureViewer {

final static int MAX_NUMBER = 8;
final static int MIN_NUMBER = 1;

private int currentNumber;

public static void main(String[] args) {
    showMenu();
}

public static void showMenu() {
    Scanner input = new Scanner(System.in);
    int current_number = MIN_NUMBER;
    boolean Continuation = true;
    while (Continuation) {

        System.out.println("Select One of the Options");
        System.out.println("Option 1: Forward");
        System.out.println("Option 2: Backward");
        System.out.println("Option 3: CreateFileName");
        System.out.println("Option 4: CreateRandomName");
        System.out.println("Option 5: Non-Static Forward");
        int Menu_Option = input.nextInt();
        switch (Menu_Option) {
        case 1:
            current_number = forward(current_number);
            System.out.println("The Current Number is: " + current_number);
            break;
        case 2:
            current_number = backward(current_number);
            System.out.println("The Current Number is: " + current_number);
            break;
        case 3:
            String fileName = createFileName(current_number);
            System.out.println("File Name: " + fileName);
            break;
        case 4:
            fileName = createRandomName(current_number);
            System.out.println("File Name: " + fileName);
            break;
        case 5: 
            PictureViewer pv = new PictureViewer();
            pv.setCurrentNumber(current_number);
            pv.forward();
            current_number = pv.getCurrentNumber();
            System.out.println("The Current Number is: " + current_number);
            break;
        }
    }
}

public static int forward(int current_number) {

    if (current_number >= MAX_NUMBER) {
        System.out.println(MIN_NUMBER);
        current_number = MIN_NUMBER;

    } else {
        System.out.println(current_number++);
    }
    return current_number;
}

public static int backward(int current_number) {

    if (current_number <= MIN_NUMBER) {
        System.out.println(current_number);
        current_number = MIN_NUMBER;
    } else
        current_number--;
    {
    }
    return current_number;
}

public static String createFileName(int current_number) {

    return "Picture" + current_number + ".gif";
}

public static String createRandomName(int current_number) {
    current_number = MIN_NUMBER + (int) (Math.random() * MAX_NUMBER);
    return "Picture" + current_number + ".gif";
}

public void forward() {
    // overloaded method, use global variable as input and output
    this.currentNumber = this.currentNumber +1;
}

public void backward() {
    // overloaded method, use global variable as input and output
}

public int getCurrentNumber() {
    return currentNumber;
}

public void setCurrentNumber(int currentNumber) {
    this.currentNumber = currentNumber;
}