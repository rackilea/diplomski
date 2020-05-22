public class FileThread extends Thread {
    private List<String> list = new ArrayList<String>();
    private boolean inThread = false;
    .......
    public int getListSize() {
        if(!inThread)
            return list != null ? list.size() : 0 ;
        else
            return 0;
    }

    public FileThread(String line) {
    }

    public void run() {
        inThread = true;
             // You logic of the thread
        inThread = false;
    }

    public static void main(String args[]) throws IOException {
     ..............

     ..............

     ..............
        System.out.println("Size" + st.getListSize());
    }

}