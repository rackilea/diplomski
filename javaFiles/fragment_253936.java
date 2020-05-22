FileOutputStream out = new FileOutputStream(filename);

[...]

out.flush();
out.getFD().sync();