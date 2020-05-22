try (BufferedReader br = new BufferedReader(new FileReader("C:\\untitled\\src\\main\\resources\\emoji.txt"))) {

    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(EmojiManager.getByUnicode(StringEscapeUtils.unescapeJava(line)).getUnicode());
     }

} catch (IOException e) {
      // error handling
}