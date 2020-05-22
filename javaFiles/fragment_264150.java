try (PrintWriter out = new PrintWriter(...)) {
    // do whatever with out
}
catch (Exception e) {
    e.print... (whatever)
}
// no need to do anything else, close is invoked automatically by try block