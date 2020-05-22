protected void inputDidChange() {
    System.out.println(inputs);

    if (contains(vid1, inputs)) {
        System.out.println("vid1");
    } else if (contains(vid2, inputs)) {
        System.out.println("vid2");
    } else if (contains(vid3, inputs)) {
        System.out.println("vid3");
    }
}

protected boolean contains(List<String> source, List<String> compare) {
    boolean contains = source.size() == compare.size();
    if (contains) {
        for (int index = 0; index < source.size(); index++) {
            if (!source.get(index).equals(compare.get(index))) {
                contains = false;
                break;
            }
        }
    }
    return contains;
}