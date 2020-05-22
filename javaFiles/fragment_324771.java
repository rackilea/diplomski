public static int inputInt(String prompt, Scanner keyboard) {
        System.out.print(prompt);
        try{
            return keyboard.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch! Please enter Numbers");
            keyboard.next();
            return inputInt(prompt, keyboard);
        }
}