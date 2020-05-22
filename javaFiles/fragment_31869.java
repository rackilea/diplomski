FileReader fr;

public Library(){
     try {
        fr = new FileReader("D:\\Users\\Adi\\Documents\\NetBeansProjects\\Hw 7Jan-13Jan\\Date.txt");
    } catch (Exception e) {
    }
     BufferedReader br = new BufferedReader(fr);
}