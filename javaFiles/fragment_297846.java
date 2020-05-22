Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
  @Override
  public void run() {
  if(comapreTwoFiles("C://temp//cache-filename.txt", "C://Desktop//filename.txt")){
    System.out.println("File is changed");
    //change your cache file
    }
  }
}, 2*60*1000, 2*60*1000);
public boolean compareTwoFiles(String path1, String path2)
            throws IOException {

    File file1 = new File(path1);
    File file2 = new File(path2);

    BufferedReader br1 = new BufferedReader(new FileReader(file1));
    BufferedReader br2 = new BufferedReader(new FileReader(file2));

    String thisLine = null;
    String thatLine = null;

    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();

    while ((thisLine = br1.readLine()) != null) {
        list1.add(thisLine);
    }
    while ((thatLine = br2.readLine()) != null) {
        list2.add(thatLine);
    }

    br1.close();
    br2.close();

    return list1.equals(list2);
}