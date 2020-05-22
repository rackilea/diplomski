@(ConsultantList:java.util.List[String])
@import helper._
@main("ADAMS") {
---------
---------
@for(element <- ConsultantList){
                <option value="@element">@element</option>
          }