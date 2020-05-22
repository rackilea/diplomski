$(w).stop(true, true);
    $(w).find(".errorAlert").remove();
    $(w).append("<div id=\"errorAlert\" class=\"rounded10 errorAlert\">" +
        "<img alt=\"\" src=\"public/images/exclamation.png\"> " +
        "You must accept the terms and conditions to finish your registration." +
        "</div>");
    $(w).fadeIn(1000);
    $(w).fadeOut(5000);
    $(w).queue(new Function(){
      public void f() {
        $(this).find(".errorAlert").remove();  
      }
    });