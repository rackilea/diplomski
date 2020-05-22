try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        char[] line = reader.readLine().toCharArray();
        for (char c : line)
            System.out.print(c);
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }