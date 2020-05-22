public static  ArrayList<HashMap<String, String>> usersList=new ArrayList<HashMap<String, String>>();


            Presence presence = new Presence(Presence.Type.available);
            Constants.connection.sendPacket(presence);
            setConnection(Constants.connection);

            final Roster roster = Constants.connection.getRoster();
            Collection<RosterEntry> entries = roster.getEntries();

            for (RosterEntry entry : entries) {

                    HashMap<String, String> map = new HashMap<String, String>();
                    Presence entryPresence = roster.getPresence(entry.getUser());

                    Presence.Type type = entryPresence.getType();       

                    map.put("USER", entry.getName().toString());
                    map.put("STATUS", type.toString());
                    Log.e("USER", entry.getName().toString());

                    usersList.add(map);

            }