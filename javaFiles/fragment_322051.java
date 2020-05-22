try {
    String translation = translate(fromLang, toLang, text);
    t2.setText(translation);
} 
catch (Exception e) {
    System.out.println(e);
}