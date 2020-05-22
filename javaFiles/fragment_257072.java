for (int i = 1; i < m-1; i++) {
                for (int j = 1; j < n-1; j++) {
                    try {//    System.out.println("number is ");
                        a[i][j] = scanner.nextInt();

                    } catch (java.util.NoSuchElementException e) {
                        // e.printStackTrace();
                    }
                }
            }         //print the input matrix