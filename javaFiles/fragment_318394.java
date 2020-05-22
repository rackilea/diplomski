try {
    while (true) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            System.out.println("Hi");
            Thread.sleep(8000);
        }
    }
} catch (InterruptedException exception) {
    // Catch something here
}