class Command {
   private String[] lines = new String[3];

   public void setLines(String[] lines) {
        if (lines != null) {
           this.lines = lines;
        }
   }

   public String getName() {
       return lines[0];
   }

   public String getParameter() {
       if (lines.length >= 2) {
          return lines[1];
       }
   }

   public String getResult() {
       if (lines.length >= 3) {
          return lines[2];
       }
   }
}