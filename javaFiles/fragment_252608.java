public class MyTextTO{
        private String mytext;

       /**Getters , setters and constructor**/

        public String getLinkifiedMyText(){

            try {
                    Pattern patt = Pattern.compile("(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\'\".,<>???“”‘’]))");
                    Matcher matcher = patt.matcher(this.mytext);    

                    if (matcher.group(1).startsWith("http://")){
                                return matcher.replaceAll("<a href=\"$1\">$1</a>");
                    }else{
                            return matcher.replaceAll("<a href=\"http://$1\">$1</a>");
                    }   
            } catch (Exception e) {
               return this.mytext;
            }
        }
}



<h:dataTable  value="#{bean.dataList}" var="row">
    <h:column>  
        <h:outputText value="#{row.linkifiedMyText}" escape="false" />
    </h:column>
</h:dataTable>