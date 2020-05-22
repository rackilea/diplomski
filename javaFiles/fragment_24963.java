private static List<Result> group(List<Input> yourList) {
    List<Result> result = new ArrayList<>();

    for (Input i : yourList) {
        String type = i.getType();
        String email = i.getEmail();
        boolean approved = i.isApproved();
        Result r = getIfExists(result, type, email);

        if(r != null){
            result.remove(r);
            r.increase(approved);
        } else{
            r = new Result(type, email, approved);
        }

        result.add(r);
    }

    return result;
}

private static Result getIfExists(List<Result> results, String type, String email) {
    Result result = null;
    boolean exit = false;
    for (int i = 0; i < results.size() && !exit; i++) {
        Result r = results.get(i);
        if (r.getType().equals(type) && r.getEmail().equals(email)) {
            result = r;
            exit = true;
        }
    }
    return result;
}