File f = new File("...");

// create all parent dirs for the target file
f.getParentFile().mkdirs();

// ... now write the file itself ...