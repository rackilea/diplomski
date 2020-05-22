public static void removeDuplicateAliases() throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyStoreException,
        UnrecoverableEntryException
{
    final String KEYSTORE_TYPE = "KEYSTORE_TYPE";
    final String KEYSTORE_PATH = "KEYSTORE_PATH";
    final char[] KEYSTORE_PASSWORD = "KEYSTORE_PASSWORD".toCharArray();

    KeyStore ks = KeyStore.getInstance(KEYSTORE_TYPE);
    ks.load(new FileInputStream(new File(KEYSTORE_PATH)), KEYSTORE_PASSWORD);

    Enumeration<String> aliases = ks.aliases();

    Map<String, List<KeyStore.Entry>> keyStoreEntriesMap = new LinkedHashMap<String, List<KeyStore.Entry>>();

    while (aliases.hasMoreElements())
    {
        String alias = aliases.nextElement();

        KeyStore.Entry entry = null;

        try
        {
            entry = ks.getEntry(alias, new KeyStore.PasswordProtection(KEYSTORE_PASSWORD));
        }
        catch (UnsupportedOperationException e)
        {
            entry = ks.getEntry(alias, null);
        }

        if (!keyStoreEntriesMap.containsKey(alias))
        {
            List<KeyStore.Entry> aliasEntry = new ArrayList<KeyStore.Entry>();
            aliasEntry.add(entry);

            keyStoreEntriesMap.put(alias, aliasEntry);
        }
        else
        {
            keyStoreEntriesMap.get(alias).add(entry);
        }
    }

    for (Map.Entry<String, List<KeyStore.Entry>> entry : keyStoreEntriesMap.entrySet())
    {
        if (entry.getValue().size() > 1)
        {
            System.out.println("Multiple entries found under same alias - \'" + entry.getKey() + "\'");

            int counter = 1;
            for (KeyStore.Entry each : entry.getValue())
            {
                ks.deleteEntry(entry.getKey());

                String newAlias = entry.getKey() + "-" + counter;

                if (each instanceof TrustedCertificateEntry)
                    ks.setEntry(newAlias, each, null);
                else
                    ks.setEntry(newAlias, each, new KeyStore.PasswordProtection(PASSWORD));

                System.out.println("\t(" + counter + " of " + entry.getValue().size() + ") Entry moved to new alias \'" + newAlias + "\'");

                counter++;
            }

            System.out.println();
        }
    }

    ks.store(new FileOutputStream(new File(KEYSTORE_PATH)), PASSWORD);

    System.out.println("Done!!");
}