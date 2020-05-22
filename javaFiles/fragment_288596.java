CompletableFuture<UUID> id = new CompletableFuture<>();
id.complete(TaskManager.newRepeatingTask(() -> {
    for (int i = 0; i < profileButtons.length; i++) {
        GuiButton button = profileButtons[i];
        button.move(-1, 0);
    }
    toMove--;
    if (toMove == 0) {
        TaskManager.cancelTask(id.join());
    }
}, 30L, 0L));