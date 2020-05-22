public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\absin\\Desktop\\catalina.out");
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.toLowerCase().contains("select ") || line.toLowerCase().contains("insert ")
                        || line.toLowerCase().contains("update ")) {
                    // DO something with the found log entry
                    System.out.println(line);
                }
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        System.out.println("Time taken : " + (System.currentTimeMillis() - start) + " milliseconds");
    }