br = new BufferedReader(new FileReader("C:\\Users\\Chris\\Desktop\\file_two.txt"));
        bw = new BufferedWriter(new FileWriter("C:\\Users\\Chris\\Desktop\\file_two_copy.txt"));
        String current_line;
        while ((current_line = br.readLine()) != null) {
            //System.out.println("Here.");
            current_line = current_line.replaceAll("\\s+", " ");
            bw.write(current_line);
            bw.newLine();
        }
        br.close();
        bw.close();
        File copyFile = new File("C:\\Users\\Chris\\Desktop\\file_two_copy.txt");
        File originalFile = new File("C:\\Users\\Chris\\Desktop\\file_two.txt");
        originalFile.delete();
        copyFile.renameTo(originalFile);