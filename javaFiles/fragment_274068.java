Comparator c = new Comparator<String>()
    {
        @Override
        public int compare( String o1, String o2 )
        {
            return getNumber( o1 ).compareTo( getNumber( o2 ) );
        }

        private Integer getNumber( String str ) 
        {
            Pattern pattern = Pattern.compile("([0-9]+)");
            Matcher matcher = pattern.matcher(str);
            while ( matcher.find() ) { return Integer.parseInt( matcher.group( 1 ) ); }

            return 0;
        }
    }