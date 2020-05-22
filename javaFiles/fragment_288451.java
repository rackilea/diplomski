@Override
public void start(Stage primaryStage) {
    // map storing the message counts by friend
    final ObservableMap<Friend, Integer> messageCount = FXCollections.observableHashMap();

    ListView<Friend> friendsListView = new ListView<>();
    friendsListView.setCellFactory(lv -> new ListCell<Friend>() {
        final StackPane messageNotification;
        final Text numberText;
        final InvalidationListener listener;

        {
            // notification item (white number on red circle)
            Circle background = new Circle(10, Color.RED);

            numberText = new Text();
            numberText.setFill(Color.WHITE);

            messageNotification = new StackPane(background, numberText);
            messageNotification.setVisible(false);

            listener = o -> updateMessageCount();
            setGraphic(messageNotification);
        }

        void updateMessageCount() {
            updateMessageCount(messageCount.getOrDefault(getItem(), 0));
        }

        void updateMessageCount(int count) {
            boolean messagesPresent = count > 0;
            if (messagesPresent) {
                numberText.setText(Integer.toString(count));
            }
            messageNotification.setVisible(messagesPresent);

        }

        @Override
        protected void updateItem(Friend item, boolean empty) {
            boolean wasEmpty = isEmpty();
            super.updateItem(item, empty);
            if (wasEmpty != empty) {
                if (empty) {
                    messageCount.removeListener(listener);
                } else {
                    messageCount.addListener(listener);
                }
            }

            if (empty || item == null) {
                setText("");
                updateMessageCount(0);
            } else {
                setText(item.getName());
                updateMessageCount();
            }

        }

    });

    Random random = new Random();
    List<Friend> friends = Stream
            .of(
                    "Sheldon",
                    "Amy",
                    "Howard",
                    "Bernadette",
                    "Lennard",
                    "Penny")
            .map(Friend::new)
            .collect(Collectors.toCollection(ArrayList::new));

    friendsListView.getItems().addAll(friends);

    List<Friend> messages = new ArrayList(friends.size() * 2);

    // 2 messages for each friend in random order
    Collections.shuffle(friends, random);
    messages.addAll(friends);
    Collections.shuffle(friends, random);
    messages.addAll(friends);

    // demonstrate adding/removing messages via timelines
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        Iterator<Friend> iterator = messages.iterator();

        @Override
        public void handle(ActionEvent event) {
            messageCount.merge(iterator.next(), 1, Integer::sum);
        }

    }));
    timeline.setCycleCount(messages.size());

    Timeline removeTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        Iterator<Friend> iterator = messages.iterator();

        @Override
        public void handle(ActionEvent event) {
            messageCount.merge(iterator.next(), 1, (a, b) -> a - b);
        }

    }));
    removeTimeline.setCycleCount(messages.size());

    new SequentialTransition(timeline, removeTimeline).play();

    Scene scene = new Scene(friendsListView);

    primaryStage.setScene(scene);
    primaryStage.show();
}