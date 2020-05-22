private static void printNumber(Integer number) {
    System.out.println(number);
}

String prefix = "The number is :";
numbers.forEach(printWithPrefix(prefix, Main::printNumber));