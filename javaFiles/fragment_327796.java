public int compare(UserDto userDto1, UserDto userDto2) {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    if (userDto1.getLastLoginDate() != null && userDto2.getLastLoginDate() != null && userDto2.getLastLoginDate().compareTo(userDto1.getLastLoginDate()) != 0) {
        String Date1 = format.format(userDto1.getLastLoginDate());
        String Date2 = format.format(userDto2.getLastLoginDate());
        if (Date1.equals(Date2)) {
            if (userDto1.getLastActionDate() != null && userDto2.getLastActionDate() != null && userDto2.getLastActionDate().compareTo(userDto1.getLastActionDate()) != 0) {
                String Date3 = format.format(userDto1.getLastActionDate());
                String Date4 = format.format(userDto2.getLastActionDate());
                if (Date3.equals(Date4)) {
                    if (userDto1.getLastName() != null && userDto2.getLastName() != null && userDto1.getLastName().compareTo(userDto2.getLastName()) != 0) {
                        return userDto1.getLastName().compareTo(userDto2.getLastName());
                    }
                } else {
                    return userDto2.getLastActionDate().compareTo(userDto1.getLastActionDate());
                }
            }
        } else {
            return userDto2.getLastLoginDate().compareTo(userDto1.getLastLoginDate());
        }

    }
    if (userDto1.getLastLoginDate() != null && userDto2.getLastLoginDate() == null) {
        return -1;
    }
    if (userDto1.getLastLoginDate() == null && userDto2.getLastLoginDate() != null) {
        return 1;
    }
    if (userDto1.getLastLoginDate() == null && userDto2.getLastLoginDate() == null) {
        return userDto1.getLastName().compareTo(userDto2.getLastName());
    } }