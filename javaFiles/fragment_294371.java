// ADD your random file picking logic here based on file Count to get boardNum
    int boardNum = 1;
    InputStream is = sysClassLoader.getResourceAsStream("GameBoards/Board" + boardNum + ".txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while((line=reader.readLine())!=null) {
        System.out.println(line);
    }