public AnimalStats(){
    simulator = new Simulator();
    try{
        fos = new FileOutputStream("AnimalStats.csv",true);
        pw = new PrintWriter(fos);
    }
    catch(IOException e) {
        System.out.println("Error has been caught!");
        e.printStackTrace();

    }
}