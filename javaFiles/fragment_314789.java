for ( column column : columns ) {
        for ( int i = 0; i < cols.size(); i++) {
            if ( this.create.indexOf( "`" + column.getName() + "`") == cols.get( i )) {
                this.order_of_columns.add( column );
            }
        }
    }