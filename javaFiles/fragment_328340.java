while (line != null) {
    if ( line.split("\\|",-1).length != 5 ) {
        valid = false;
        break;
    }
    line = buffReader.readLine();
}