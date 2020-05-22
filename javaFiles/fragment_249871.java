public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    Player p = (Player) sender;

    if (cmd.getName().equalsIgnoreCase("akitz")) {

        if (args.length != 1) {

            p.sendMessage("§cIncorrect argument count!");

        }

        if (args[0].equalsIgnoreCase("legend")) {

            p.sendMessage("§bYou got a kit §3Legend");
            CustomItems.givela(p);
            CustomItems.givels(p);
            p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
            return true;

        }

        if (args[0].equalsIgnoreCase("god")) {

            p.sendMessage("§bYou got a kit §3God");
            CustomItems.givega(p);
            CustomItems.givegs(p);
            p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
            return true;

        }

        if (!args[0].equalsIgnoreCase("legend") | !args[0].equalsIgnoreCase("god")) {

            p.sendMessage("§cIncorrect argument!");

        }

    }

    return false;

}