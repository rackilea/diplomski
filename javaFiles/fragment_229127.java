String[] words = {"Gallinule", "Escambio", "Aciform", "Entortilation", "Extensibility"};
int sum = Arrays.stream(words)
        .filter(w -> w.startsWith("E"))
        .mapToInt(w -> w.length())
        .sum();
System.out.println("Sum of letters in words starting with E... " + sum);