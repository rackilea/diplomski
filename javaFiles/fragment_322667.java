CIFSContext base = SingletonContext.getInstance();
CIFSContext authed1 = base.withCredentials(new NtlmPasswordAuthenticator(domain, userName, password));

SmbFile sFile = new SmbFile("smb://" + exportLocation + fileName, authed1);
SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
OutputStreamWriter out = new OutputStreamWriter(sfos);

CSVPrinter csvPrinter = new CSVPrinter(out, CSVFormat.DEFAULT.withDelimiter(';'));