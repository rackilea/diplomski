public static void main(String[] args) throws FileNotFoundException, IOException {
        try(FileInputStream fin = new FileInputStream("Demo.txt"))
        {
            //This block is executed successfully
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Will it be executed if error occurs in try clause");
    }