for(DataSnapshot ds : snapshot.getChildren())
                            {
                                name = ds.getValue(String.class);
                                acct = ds.getValue(String.class);
                                DjProfile model = new DjProfile(name);
                                model.setDjName(name);
                            }