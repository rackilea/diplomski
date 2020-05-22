private boolean isNotEmptyOrNull(List list) {
    return list != null && !list.isEmpty() ? true : false;
}

private boolean orObjects(List... args) {

    if (args.length == 0)
        return false;

    return isNotEmptyOrNull(args[0]) ?
            true : orObjects(Arrays.copyOfRange(args, 1, args.length));

}