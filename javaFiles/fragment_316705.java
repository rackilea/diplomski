String word= "hello java";

for (String part : word.split(" ")) {
    System.out.print(new StringBuilder(part).reverse().toString());
    System.out.print(" ");
}