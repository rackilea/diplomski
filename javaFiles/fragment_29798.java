try {

    String result = instance.doOCR(imageFile);
    FileWriter writer = new FileWriter("C:\\testfiles\\enes.txt");
    try(PrintWriter printWriter = new PrintWriter(writer)){
    printWriter.write(result);
    printWriter.write("\r\n");
}
   System.out.println(result);
} catch (Exception e) {
        System.err.println(e.getCause());
}