public static void main(String[] args) {
    try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/path/to/test.txt")));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        int offset = 7;

        while((line = bufferedReader.readLine()) != null) {
                for(int i=0; i<line.length(); i++) {
                    if(i == offset) {
                        stringBuilder.append("xyz" + line.charAt(i));
                    } else if(i == line.length()-1) {
                        stringBuilder.append(line.charAt(i) +"\n");
                    } else {
                        stringBuilder.append(line.charAt(i));
                    }
                }
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }       
}