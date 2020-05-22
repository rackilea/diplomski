public static void main(String[] arg){
         HtmlCleaner cleaner = new HtmlCleaner();
         try {
             TagNode nodes = cleaner.clean(new File("c:/test.xml"));
             Object[] objects = nodes.evaluateXPath("//div/a[text(.,'In')]");
             System.out.println(((TagNode)objects[0]).getText());
         } catch (Exception e) {
            e.printStackTrace();
        }
    }