@Override
public void respond(RequestCycle requestCycle) {
    super.respond(requestCycle);
    // Delete the file
    ((FileResourceStream)getResourceStream()).getFile().delete();
}