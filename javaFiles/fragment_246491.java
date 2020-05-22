String arg1 = "hello";
int arg2 = 10;

Desktop desktop = Optional.ofNullable(status)
    .map(Status::getDesktop)
    .ifPresent(desktop -> this.workWithDesktop(desktop, arg1, arg2));