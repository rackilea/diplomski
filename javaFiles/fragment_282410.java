BufferedOutputStream buffer = new BufferedOutputStream(super.getOutputStream());

    FilterOutputStream filter = new FilterOutputStream(buffer) {
        @Override
        public void write( int b ) throws IOException {
            // modify b
            out.write( b );
        }
    };

    return new DelegatingServletOutputStream(filter);