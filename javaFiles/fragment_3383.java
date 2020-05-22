Printer printer = null;
try {
printer = new Printer(Printer.TM_T88, Printer.MODEL_ANK, this);
}
catch (Epos2Exception e) {
//Displays error messages
}