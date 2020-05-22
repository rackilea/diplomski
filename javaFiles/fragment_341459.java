public class SearchBuffer {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String charset= "US-ASCII";
        byte[] searchedFor = "ciao".getBytes(charset);
        byte[] input = "aaaciaaaciaojjcia".getBytes(charset);

        int idx = search(input, searchedFor);
        System.out.println("index: "+idx); //should be 8
    }

    public static int search(byte[] input, byte[] searchedFor) {
        //convert byte[] to Byte[]
        Byte[] searchedForB = new Byte[searchedFor.length];
        for(int x = 0; x<searchedFor.length; x++){
            searchedForB[x] = searchedFor[x];
        }

        int idx = -1;

        //search:
        Deque<Byte> q = new ArrayDeque<Byte>(input.length);
        for(int i=0; i<input.length; i++){
            if(q.size() == searchedForB.length){
                //here I can check
                Byte[] cur = q.toArray(new Byte[]{});
                if(Arrays.equals(cur, searchedForB)){
                    //found!
                    idx = i - searchedForB.length;
                    break;
                } else {
                    //not found
                    q.pop();
                    q.addLast(input[i]);
                }
            } else {
                q.addLast(input[i]);
            }
        }

        return idx;
    }
}