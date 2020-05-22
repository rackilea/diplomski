for (Tag tag : tags) {
    if (tag.getKey().equals("start")) {
        starts = 1;
    } else if (tag.getKey().equals("end")) {
        ends = 1;
    }

    if ((starts + ends) == 2) {
        break;
    }
}