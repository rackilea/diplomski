private HashMap hashMap = new HashMap();
private StringBuffer buff = new StringBuffer();
private int c = 0;
private String[] post;    public PostInputStream(InputStream in) {

    try {
        //Initalizes avaliable buff
        if (in.available() != 0) {
            this.buff.appendCodePoint((this.c = in.read()));
            while (0 != in.available()) {
                //Console.output(buff.toString());
                buff.appendCodePoint((this.c = in.read()));
            }

            this.post = buff.toString().split("&");

            for (int i = 0; i < this.post.length; i++) {
                String[] n = this.post[i].split("=");
                if (n.length == 2) {
                    hashMap.put(URLDecoder.decode(n[0], "UTF-8"), URLDecoder.decode(n[1], "UTF-8"));
                } else {
                    Console.error("Malformed Post Request.");
                }
            }
        } else {
            Console.error("No POST Data");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}