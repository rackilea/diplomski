for (int j=i+1; j<=i+3; j++){
    if (fileContent.size() < j && !fileContent.get(j).matches(PATTERN)){
        return false;
    } else {
        break;
    }
}