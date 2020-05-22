private final List<int[]> votes = new ArrayList<>();

private void addVote(int... preferences) {
    // convert to array of candidate indices sorted descendingly by preference
    int[] votes = new int[preferences.length];
    for (int i = 0; i < preferences.length; i++) {
        votes[preferences[i] - 1] = i;
    }
    this.votes.add(votes);
}

private static void createHierarchy(TreeItem<VoteEntry> parent, List<int[]> votes, int index) {
    int max = votes.stream().mapToInt(a -> a.length).max().getAsInt();
    if (max > index) {
        // group by candidate
        Map<Integer, List<int[]>> groups = votes.stream().collect(Collectors.groupingBy(a -> a.length > index ? a[index] : -1));
        groups.forEach((candidate, vts) -> {
            if (candidate != -1) {
                VoteEntry entry = new VoteEntry(candidate, vts.size());
                TreeItem<VoteEntry> item = new TreeItem<>(entry);
                parent.getChildren().add(item);
                createHierarchy(item, vts, index + 1);
            }
        });

        // sort by candidate
        parent.getChildren().sort(Comparator.comparingInt(ti -> ti.getValue().getCandidate()));
    }
}

@Override
public void start(Stage primaryStage) {
    addVote(1, 2, 3, 4);
    addVote(4, 3, 2, 1);
    addVote(1, 3, 2, 4);
    addVote(2, 1, 4, 3);
    addVote(2, 4, 3, 1);
    addVote(2, 1, 3, 4);
    // ...

    ObservableList<String> candidateNames = FXCollections.observableArrayList(
            "Candidate 1",
            "Candidate 2",
            "Candidate 3",
            "Candidate 4"
            );

    TreeItem<VoteEntry> root = new TreeItem<>();
    createHierarchy(root, votes, 0);

    TreeTableView<VoteEntry> view = new TreeTableView<>(root);
    view.setShowRoot(false);

    TreeTableColumn<VoteEntry, String> candidateColumn = new TreeTableColumn<>("candidate");
    candidateColumn.setCellValueFactory(data -> Bindings.valueAt(candidateNames, data.getValue().getValue().candidateProperty()));

    TreeTableColumn<VoteEntry, Integer> votesColumn = new TreeTableColumn<>("votes");
    votesColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("voteCount"));

    view.getColumns().addAll(candidateColumn, votesColumn);

    Scene scene = new Scene(view);

    primaryStage.setScene(scene);
    primaryStage.show();
}