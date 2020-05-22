public static void main(String[] args){
    String a = "before";

    try (CharArrayWriter br = new CharArrayWriter()) {
        br.writeTo(null);
    } catch (IOException e){
        System.out.println(e.getMessage());
    }

    String a2 = "after";
}