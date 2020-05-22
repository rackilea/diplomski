for (int sourcePos = 0; sourcePos < source.length() ; sourcePos++) {
    boolean compt = false;

    for (int sepPos = 0; sepPos < sep.length(); sepPos++) {
        if (source.charAt(sourcePos) == sep.charAt(sepPos)) { 
            compt = true;
            break;
        }
    }

    if (compt) {
        result[index] = str;
        index++;
        str = "";
    } 

    else if(sourcePos == source.length()-1) {
        result[index] = str + source.charAt(sourcePos);
    }

    else {
        str = str + source.charAt(sourcePos);
    }
}