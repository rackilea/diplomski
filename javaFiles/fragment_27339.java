String fileName = null;

       try {
            fileName = args[0];
        } catch (Exception e) {
            System.out.println("Enter the name of the file :");
        }
        File file = new File(fileName);