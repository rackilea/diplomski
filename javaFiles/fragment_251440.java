this.table = new JTable()
    {
        private static final long serialVersionUID = -5739534894469353266L;


        /**
         * Set the background color of the row equal to the color of the path in the map
         */
        @Override
        public Component prepareRenderer( final TableCellRenderer renderer, final int Index_row, final int Index_col )
        {
            final Component comp = super.prepareRenderer( renderer, Index_row, Index_col );
            // even index, selected or not selected

            if ( Index_col == 1 )
            {
                // Color column, match foreground / background colors
                comp.setBackground( MyColors.getColor( Index_row ) );
                comp.setForeground( MyColors.getColor( Index_row ) );
            }
            else
            {
                comp.setBackground( Color.white );
                comp.setForeground( Color.black );
            }
            return comp;
        }
    };