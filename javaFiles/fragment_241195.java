try (InputStream is = new URL(url).openStream()) {
    Path file = Bukkit.getServer().getUpdateFolderFile().toPath();
    Files.copy(is, file, StandardCopyOption.REPLACE_EXISTING);
} catch (IOException ex) {
    ex.printStackTrace();
}