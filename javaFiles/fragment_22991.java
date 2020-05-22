<script>
//<![CDATA[
                function collectOrderFromTable() {
                    var coffeeCups = [];
                    //get table rows
                    var tableRows = PF('dataTableWidget').tbody[0].childNodes;
                    //loop through rows    
                    for (i = 0; i < tableRows.length; i++) {
                        //get cells of current row
                        var cells = tableRows[i].cells;
                        //get value of hidden ID column
                        var id = cells[0].innerText;
                        //get quantity from input field
                        var quantity = cells[3].firstChild.value;
                        //add new item to array
                        coffeeCups.push({id: id, quantity: quantity});
                    }
                    console.log("Coffee cups", JSON.stringify(coffeeCups));
                    sendToOrderBean([{name: 'coffeeCups', value: JSON.stringify(coffeeCups)}]);
                }
//]]>
            </script>