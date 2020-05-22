try {
    // code
}
catch (MyInconsequentialException mie) {
   // tune level for this logger in logging config file if this is too spammy
   MY_LOGGER.warning("Caught an inconsequential exception.", mie);
}