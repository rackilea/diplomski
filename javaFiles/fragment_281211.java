public static void pLine (String FileName)throws IOException{
Scanner scanner = null;
try{
    scanner = new Scanner(new BufferedReader(new FileReader(FileName)));
    String line;
    ArrayList<String> inside;
    Scanner inner;
    int start;
    int end = 0;
    while (scanner.hasNextLine()) {
           line = scanner.nextLine();
           inside = new ArrayList<String>();
           start = line.indexOf("<<<", end);       
           end = line.indexOf(">>>", start+1);
           if (end > start) {
                inner = new Scanner(line.substring(start +3, end ));
                while (inner.hasNext()) {
                    inside.add(inner.next());
                }
            }
            System.out.println("inside : " + inside);
        }
    }
    catch (Throwable t) {
        t.printStackTrace();
    }
    finally {
        scanner.close();
    }
}