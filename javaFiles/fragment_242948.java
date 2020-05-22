@Override
    public String getFormattedInfo(User user) {
        String text = String.format("| %-10s| %-25s| %-25s| %-20s| %-10s|%n", Integer.toString(getId()),
                getFirstName(), getLastName(), getPhoneNumber(), getAddress());
    text += " ------------------------------------------------------------------------------------\n";
    return text;
    }