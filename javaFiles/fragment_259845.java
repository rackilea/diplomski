Properties userProps = new Properties();
Path userFile = Paths.get(System.getProperty("user.home") + "/userdata.properties");

void loadUserProps() {
    try (BufferedReader in = Files.newBufferedReader(userFile,
                StandardCharsets.UTF_8)) {
        userProps .load(in);
    }
}

void saveUserProps() {
    try (BufferedWriter out = Files.newBufferedWriter(userFile,
                StandardCharsets.UTF_8)) {
        userProps .store(out, "-- " + new Date());
    }
}

loadUserProps();

String old = userProps.getProperty("Pooja", "0");
int n = Integer.parseInt(old) + 10;
userProps.setProperty("Pooja", Integer.toString(n));

saveUserProps();