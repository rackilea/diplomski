try( FileOutputStream fos = new FileOutputStream(file) ) {
    for(String s : str) {
        byte[] tmptxt = s.getbytes(Charset.forName("UTF-8"));  
        byte[] encTxt = cipher.doFinal(tmptxt);
        w.write(encTxt);
    }
} catch(IOException e) {
    // print error or whatever
}