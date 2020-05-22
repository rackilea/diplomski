String sTmp = start;
    String eTmp = end;
    while (!sTmp.equals(eTmp) && i <= start.length()) {
        sTmp = start.substring(0, start.length() - i);
        eTmp = end.substring(i, end.length());
        i++;
    }
    if (sTmp.equals(eTmp)) {
        result = sTmp;
    } else {
        result = "";
    }
    return result;