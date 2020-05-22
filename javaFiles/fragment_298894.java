while (inputStream.hasNextLine()) {

    Integer luser = Integer.parseInt(inputStream.nextLine());
    String lpass = inputStream.nextLine();
    newFile[count] = new accessNode(luser, lpass);
    count++;
}