if (funct.equals("-"))
        {
            System.out.println("Simple subtraction calculator");
            System.out.println("Enter first num: ");
            fnum = Double.parseDouble( reader.nextLine());
            System.out.println("Enter second num: ");
            snum = Double.parseDouble( reader.nextLine());
            answer = fnum - snum;
            System.out.println("Answer: " + answer);
            System.out.println(" ");
        }