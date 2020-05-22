for (int i=0; i<line.length(); i++){
    sb.append(line.charAt(i));
    counter++;
    if (counter==160){
        sb.append("\n");
        counter = 0;
    }
}