int n = -1;
        Scanner sc = new Scanner(System.in);
        String line;

        while (n != 0){
            line = sc.nextLine();
            String[] splits = line.split(" ");
            System.out.println(Arrays.toString(splits));

            for (String split : splits) {
                try {
                    n = Integer.parseInt(split);
                    if (n == 0)
                        break;
                    //Graph G = new Graph();
                    //G.CreateAdjListGraph(n);

                } catch (NumberFormatException e) {
                    // handling
                }
            }
        }