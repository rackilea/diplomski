@Override
public String[] profilesToActivate() {
    if (cron != null) {
        return new String[] { "use-cron" };
    }
    else if (fixedDelay != null) {
        return new String[] { "use-delay" };
    }
    else {
        return new String[] { "use-date" };
    }
}