Integer[] temp = new Integer[column2.size()];
            switch (num) {
                case 1:
                    Scanner case1 = new Scanner(System.in);
                    System.out.println("Enter a number from first column to see how many occurrences it has: "); 
                    int numb = case1.nextInt();
                    System.out.println(column2.get(numb));
                    break;
                case 2:
                    occurrence(column2.toArray(temp));
                    break;
                case 3:
                    occurrences(column2.toArray(temp));
                    break;              
                default: System.out.println("the number is not 1 or 2 or 3!"); 
            }