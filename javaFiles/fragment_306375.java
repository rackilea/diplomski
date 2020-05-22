try {
            File f = new File("input.txt");
            Scanner scan = new Scanner(f);
            scan.useDelimiter("\\s*,\\s*");
            String nextLine; //left it in even tho you are not using it
            int[] testAry = new int[10];
            int i = 0;

            while (scan.hasNextInt()) {
                testAry[i] = scan.nextInt();
                System.out.println(testAry[i]);
                i++;
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }