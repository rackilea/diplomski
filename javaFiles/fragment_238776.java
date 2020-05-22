private void WebJSoup_jButtonActionPerformed(java.awt.event.ActionEvent evt) {
   try{
         Document doc=Jsoup.connect("http://www.imdb.com/search/title?groups=top_250&sort=user_rating").userAgent("Mozilla/17.0").get();
         Elements  links=doc.select("h3.lister-item-header");
         StringBuilder sb = new StringBuilder ();
         links.stream().forEach(e->sb.append(e.text()).append(System.getProperty("line.separator")));
         jTextArea1.setText(sb.toString());
   }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
   }

}