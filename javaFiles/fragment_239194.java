BufferedReader in = new BufferedReader(new FileReader("Path_to/java.txt"));
        String line;
        int[] data = null;

        while((line = in.readLine()) != null) {
            String[] a = line.split(","); //read in all numbers in file
            data = new int[a.length]; //convert those numbers from Strings to ints
            System.out.println("1data.length: " + data.length);
            for(int i = 0; i < a.length; i++) {
                data[i] = Integer.parseInt(a[i]);
                System.out.println(data[i] + ","); //testing
            }
        }

        System.out.println("data.length: " + data.length);
        for(int i = 0; i < data.length; i++) {

            System.out.print(data[i] + ",");
        }

    }