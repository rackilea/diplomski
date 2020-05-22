for (String question : questionsList) {
    timer.schedule(task(() -> System.out.println(question)), 0);
    try {
        sleep(2000);
    } catch (Exception ignored) {}
}