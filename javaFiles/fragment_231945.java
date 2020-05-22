int line = 0;
 while((readline = br.readLine()) != null) {
     System.out.println(readline); //loads the maze
     char[] charArr = readline.toCharArray();
     maze[line] = charArr;
     line++;
 }