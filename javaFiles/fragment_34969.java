@Override
public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("  ");
    for(int i = 0; i < NS.length; i++){
        sb.append(NS[i]+" ");
    }
    sb.append("\n");
    sb.append("   " + StringUtils.repeat("-", board.length) + "\n");