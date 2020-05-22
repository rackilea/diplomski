if(task.isSuccessful())
                {
                    mSalons.clear();
                    List<DocumentSnapshot> result = task.getResult();
                    iOnLoadCountSalon.onLoadCountSalonSuccess(result.size());
                    for(DocumentSnapshot salonSnapShot : result)
                    {
                        Salon salon = salonSnapShot.toObject(Salon.class);
                        mSalons.add(salon);
                    }
                    iBranchLoadListener.onBranchLoadSuccess(mSalons);
                }