PDRadioCollection coverage = theForm.getField("radio collection");
kids = coverage.getKids();
for (Object kid : kids) {
   if (kid instanceof PDCheckbox) {
      PDCheckbox checkbox = (PDCheckbox) kid;
      String partialName = checkbox.getPartialName();
      if (partialName.equals("loan")) {
         checkbox.check();
      } else {
         checkbox.unCheck();
      }
   }
}