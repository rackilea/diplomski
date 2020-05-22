void changeString(ChangeableString str) {
    str.changeTo("Hello world");
}

main() {

    ChangeableString myStr = new ChangeableString("");
    changeString(myStr);
}