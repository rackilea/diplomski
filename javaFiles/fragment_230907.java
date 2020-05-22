[serviceTable, groupsTable].each { table ->
    bind(source:table, sourceProperty:'preferredSize', 
         target:table, targetProperty:'preferredScrollableViewportSize',
         converter: { ps -> 
             [ps.width + 100, 
              (table.rowCount > 20 ? 20: table.rowCount) * table.rowHeight]
         })
}