System.out.print("continue?");
while (!cont.equals("\n")) {
   cont = input.next();
   answer += cont;
}
} while (answer.equalsIgnoreCase(yes));