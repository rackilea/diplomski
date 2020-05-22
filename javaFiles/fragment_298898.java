int[][] imageArray = null;

try{
        Scanner file = new Scanner(new File("room.dat"));
        int cnt = file.nextInt();
        int cnt2 =file.nextInt();   
        imageArray = new int[cnt][cnt2];
        ...

}catch(FileNotFoundException e){
    System.out.println("Error");
}