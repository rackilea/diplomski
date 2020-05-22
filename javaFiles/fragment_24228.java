jQuery.noConflict();
    $(window).load(function () {
         $(document).delegate("#firsttable td", "click", function (event) {
             var columnNumber = jQuery(this).index();//get index of clicked row
         var colval=jQuery(this).find('div span').text()); // get the column value
         $("#selectedId").val(colval); //set value in the inputtext
         $("#selectedId").change(); //this will trigger the ajax listener
       });
    });