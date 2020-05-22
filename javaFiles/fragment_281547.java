NumberFormatter nfsoc   = new NumberFormatter();
NumberFormat nf         = NumberFormat.getIntegerInstance();
nf.setGroupingUsed(false); // It removes any separator
nfsoc.setFormat(nf);
nfsoc.setMaximum(Short.MAX_VALUE*2 - 1);
nfsoc.setMinimum(1);
nfsoc.setAllowsInvalid(false);