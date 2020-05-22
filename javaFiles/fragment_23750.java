public String get(int index)
    {
        assert ( index >= 0 )
        if ( index == 0 ) {
            return this.item;
        } else {
            index--;
            if ( next == null ) {
                return Null;
            }
            return next.get(index)
        }
    }