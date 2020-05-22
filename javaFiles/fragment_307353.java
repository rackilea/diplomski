public static void main(final String[] args) throws Exception {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("test"));
            final StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("Value is : " + sb.toString());
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }