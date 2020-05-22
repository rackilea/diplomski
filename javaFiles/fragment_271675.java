BufferedReader br = null;
    String[] characters = new String[1024];//just an example - you have to initialize it to be big enough to hold all the lines!

    try {

        String sCurrentLine;
        br = new BufferedReader(new FileReader("data.txt"));

        int i=0;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split(" ");
            //for the first line it'll print
            System.out.println("arr[0] = " + arr[0]); // h
            System.out.println("arr[1] = " + arr[1]); // Vito
            System.out.println("arr[2] = " + arr[2]); // 123
            if(arr.length == 4){
                System.out.println("arr[3] = " + arr[3]);
            }

            //Now if you want to enter them into separate arrays
            characters[i] = arr[0];
            // and you can do the same with
            // names[1] = arr[1]
            //etc
            i++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }