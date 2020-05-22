private List<Camp> skipByComparison(List<Camp> usersList){
    Set<Camp> s = new TreeSet<>((o1, o2) -> o1.getUserId().getId().equals(o2.getUserId().getId()) ? 
            o1.getCreateDt().compareTo(o2.getCreateDt()) : 0);
    s.addAll(usersList);
    return new ArrayList<>(s);
}