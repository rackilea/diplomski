datatable.setTotalWidth(document.right(document.rightMargin()) - 
    document.left(document.leftMargin()));

datatable.writeSelectedRows(0, -1, document.left(document.leftMargin()),
    datatable.getTotalHeight() + document.bottom(document.bottomMargin()),
    writer.getDirectContent());