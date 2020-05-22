try {
        File file = new File("info.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str = br.readLine();

        File file2 = new File("temp.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

        bw.write(str);

        br.close();
        bw.close();
        if (!file.delete()) {
            System.out.println("delete failed");
        }
        if (!file2.renameTo(file)) {
            System.out.println("rename failed");
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }