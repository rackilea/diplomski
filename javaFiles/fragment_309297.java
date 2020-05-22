FileConfiguration config; // ...
ConfigurationSection path = config.getConfigurationSection("sellall" + ranks);

Material key = Material.IRON_BLOCK;
Object value; // ...
path.set(key.name(), value);

for (String key : path.getKeys(false)) {
    Material material = Material.getMaterial(key);
}