String[] strArr = textContent.split("\\r?\\n");
    StringBuilder stringBuilder = new StringBuilder();
    boolean appendLines = false;
    for(String strLines : strArr) {
        if(strLines.contains("Tax%")) {
            appendLines = true;
            continue;
        }
        if(strLines.contains("\"ErrorMessage\"")) {
            break;
        }
        if(appendLines){
            stringBuilder.append(strLines);
            stringBuilder.append(System.getProperty("line.separator"));
        }
    }

    textContent =  stringBuilder.toString();