static void buildString( SimpleNode n, String indentation, StringBuilder out ) {
    swtich( n.id ) {
        ...
        case ID: out.append( n.jjtGetValue() ) ; break ;
        ...
    }
}