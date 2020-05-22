function getButtonSet(topCategory){
    $('#renderList').empty();
    (function(){
         var t, tt;                        
         category.forEach(renderProductList);
         function renderProductList(element, index, arr) {
            var inputElement = document.createElement("input");                                    
            inputElement.setAttribute("type", "button");
            inputElement.setAttribute("value", element);
            inputElement.setAttribute("name", element);
            var foo = document.getElementById("renderList");
            foo.appendChild(inputElement);
            t = document.createTextNode(element);
          }
     }
}