$("#addrow").on("click", function () {
        counter++;

        var newRow = $("<tr>");
        var cols = "";
        cols += '<td><input type="text" name="product"/></td>';
        cols += '<td><input type="text" name="price"/></td>';
        cols += '<td><input type="text" name="qty"/></td>';
        cols += '<td><input type="text" name="linetotal" readonly="readonly"/></td>';
        cols += '<td><a class="deleteRow"> x </a></td>';
        newRow.append(cols);
        alert(cols);
        $("table.order-list").append(newRow);
    });