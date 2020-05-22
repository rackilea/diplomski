while (line != null) {
    if ( countPipes(line) != 4 ) {
        valid = false;
        break;
    }
    line = buffReader.readLine();
}