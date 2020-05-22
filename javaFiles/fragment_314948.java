int theValue = 0;

try {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String value = input.next();

            try{
                theValue = Integer.parseInt(value);
            }catch (Exception e){
                //Just ignore it and carry on.
            }



        }
        input.close();


    } catch (IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }
}