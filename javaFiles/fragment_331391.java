Scanner keyboard=new Scanner(System.in);

System.out.println("Input how many numbers you want to find the median for (numerical value) :");
int num = keyboard.nextInt();
System.out.println("Please enter " + num + " numbers.");
int[] values = new int[num];
for (int i = 0; i < num; i++) {
    values[i] = keyboard.nextInt();        
}

for (int i = 0; i < num; i++) {
    System.out.println(values[i]);        
    }

   } 
}