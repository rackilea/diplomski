public static void main(String[] args) {
    try {
        String code = "class foo { // class named foo\n" + 
                      "public void fo() { // a method no parameter named fo\n" + 
                      "int[]a = {\n" + 
                      " 1,2,3,4\n" + "};\n" + 
                      "for(int b : a){ // loop b as many as a\n" + 
                      "if(b%2==0){\n" + 
                      " System.out.println(b); // print out b\n" + 
                      "}\n" + "}\n" + "}\n" + "}";

        String requiredData = "";
        short count = 1;
        for (String data : code.split("\n")) {
            if (data.contains("//") || data.contains(";")) {
                requiredData = requiredData + data;
                System.out.println(count + ". " + requiredData);
                requiredData = "";
                count++;
            } else {
                if (requiredData.isEmpty())
                    requiredData = data + "\n";
                else
                    requiredData = requiredData + data + "\n";
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}