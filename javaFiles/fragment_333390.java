String FileContent=null;
        Scanner sc = null;
        try {

            sc = new Scanner(new File("src/main/resources/" + ""));
            FileContent = sc.useDelimiter("\\Z").next();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }