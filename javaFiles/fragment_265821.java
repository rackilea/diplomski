case '\\':
    if(str.charAt(i+1)!='u')
        result.append("\\\\");
    else 
        result.append("\\");
break;