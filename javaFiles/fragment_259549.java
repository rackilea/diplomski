Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

    @Override
    public void run() {

        if (hasMoved.get(p.getName()) == false) {
            noPVP.remove(p.getName());
            p.sendMessage(ChatColor.YELLOW + "You have turned PVP on!");
        } else {
            p.sendMessage(ChatColor.RED + "You moved so the action was cancelled.");
        }
    }
}, 100L);