// Change:
// RepAppor.class.getClassLoader().getResourceAsStream
// to just:
// RepAppor.class.getResourceAsStream

// Expects 'Populations' to be in the same directory as the RepAppor class.
InputStream in = RepAppor.class.getResourceAsStream("Populations/" + fileName);

// Expects 'Populations' to be in the root of the classpath.
InputStream in = RepAppor.class.getResourceAsStream("/Populations/" + fileName);