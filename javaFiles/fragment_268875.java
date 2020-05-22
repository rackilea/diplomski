try{
        FileWriter fwriter = new FileWriter(YourFile);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        bwriter.write(sb.toString());
        bwriter.close();
     }
    catch (Exception e){
          e.printStackTrace();
     }