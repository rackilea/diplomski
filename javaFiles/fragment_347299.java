$(".categoryItem").click(function(event){
      $("#browseBookArea").fadeToggle(100);
      var currentId = $(this).attr("id");
      $.get("GetBookFromCategoryServlet",{selectedCat:currentId, currentPage:1}, function(data){
             $("#browseBookArea").fadeIn(300); 
             $("#browseBookArea").load("Components/browseBookArea.jsp");                                  
             });
      });