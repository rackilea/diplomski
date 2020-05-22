try (Scanner scanner = new Scanner(new File(args[0]))) {
            int N = Integer.parseInt(scanner.nextLine());
            int[] result = new int[N];
            int resultIncreamenter = 0;
            // here for loop logic can be replaced with above 3 logic
            for (int i = 1; i <= N; i++) {
                boolean isPrime = true;
                for (int j = 2; j < Math.sqrt(i - 1); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    result[resultIncreamenter++] = i;
                }
            }
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j]);
                if (j < result.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }