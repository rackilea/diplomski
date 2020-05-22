public void setActiveUsers(ArrayList<User> activeUsers) {
    Platform.runLater(new Runnable() {
        @Override public void run() {
            for(User user:activeUsers) {
                fpOnlineUsers.getChildren().add(new Button(user.getName()));
            }
        }
    }
});