int num1 = Integer.parseInt(args[0]);
int num2 = Integer.parseInt(args[1]);

for(int counter = 0; counter<=num1;counter++) {
        StringBuilder exclamations = new StringBuilder();
        for(int i = 0 ; i < num2 ; i++) {
            exclamations.append("!");
        }
        System.out.println("Hello, World" + exclamations.toString());
}