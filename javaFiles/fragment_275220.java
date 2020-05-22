if( ind>=0 )
    str = new StringBuilder(str.length()+1)
                .append(str, 0, ind)
                .append('\\')
                .append(str, ind, str.length())
                .toString();