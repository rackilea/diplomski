@form(action = routes.Application.newPaper()) {
   @inputText(paperForm("title"))

   @******* Indexed chekbox name *********@
   @for((t, index) <- topics.zipWithIndex) {
       <input type="checkbox" name="topics[@index]" value="@t">@t <br>
   }

   <input type="submit" value="Create">
}