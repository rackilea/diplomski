for (String tz : TimeZone.getAvailableIDs()) {
    if (tz.equals("CDT")) {
        System.out.println("Found: " + tz);
    }
}

System.out.println("Not found => CDT");