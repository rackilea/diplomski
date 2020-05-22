private List<Camp> skipByComparisonStream(List<Camp> usersList) {
    return new ArrayList<>(usersList.stream()
            .collect(Collectors.toMap(c -> c.getUserId().getId(),
                    Function.identity(),
                    (a, b) -> a.getCreateDt().after(b.getCreateDt()) ? a : b))
            .values());
}