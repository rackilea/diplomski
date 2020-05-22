dataTable = new javax.swing.JTable(){
        @Override
        public Printable getPrintable( PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat ) {
            return new MyPrintable( this, printMode, headerFormat, footerFormat );
        }
    };