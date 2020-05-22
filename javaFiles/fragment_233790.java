ArrayList<String> list = new ArrayList<String>();
    list.add("Doctor Review");
    list.add("3rd Party Contact");
    list.add("Appointment");
    list.add("24-Hour Service");
    list.add("Doctor Preparation");
    ArrayList<String> newlist = new ArrayList<>();
    Collections.sort(list);
    for (String x : list)

    {
        if (!Character.isDigit(x.charAt(0))) {
            newlist.add(x);
        }
    }

    for (String x : list)

    {
        if (Character.isDigit(x.charAt(0))) {
            newlist.add(x);
        }
    }