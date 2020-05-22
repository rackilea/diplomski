try {
        File file = new File(dir, "myData.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }

    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }