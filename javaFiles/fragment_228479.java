muc.join(user,password);

List<String> occupantsAtJoinTime = muc.getOccupants();

                    for (String occupant : occupantsAtJoinTime)
                    {
                        System.out.println("occupant: "+occupant);
                        //actions
                    }