String[] itemNames = getConfig().getString("Kits." + args[0] + ".names").split(",");

        for (int i = 0; i < itemNames.length; i++) {
            kitDisplayName.setDisplayName(itemNames[i]);
            kit.setItemMeta(kitDisplayName);
        }