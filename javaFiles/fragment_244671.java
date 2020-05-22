char c = 'Y';
while(c == 'y' || c == 'Y'){
    //stuff happens..
}
try {

    c = (char)System.in.read();

} catch (IOException e) {

    e.printStackTrace();//or however you choose to handle this
}