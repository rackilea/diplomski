List<String> listSCBPLNewErrMsgs = null;
if(SCBPL_NEW_ERRORMESSAGES != null) {
    listSCBPLNewErrMsgs= new ArrayList<String>(Arrays.asList(SCBPL_NEW_ERRORMESSAGES.split("\\$\\@")));
}
else {
    listSCBPLNewErrMsgs = new ArrayList<>();
}