public static void main(String[] args) {
    File f = new File("File");
    File y = new File("Test.yml");

    if(!y.exists()) {
        System.out.println(y.getName()); //Note the change here
        boolean works = false;

        try{
            y.createNewFile(); //and here
            works = true;
        }catch(SecurityException e) {
            e.printStackTrace();

        }
        if(works) {
            System.out.println("File created");
        }
    }
    if(!f.exists()) {
        System.out.println(f.getName());
        boolean works = false;

        try{
            f.mkdir();
            works = true;
        }catch(SecurityException e) {
            e.printStackTrace();

        }
        if(works) {
            System.out.println("Made the directory");
        }
    }
}