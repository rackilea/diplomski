mMap.setOnMarkerClickListener(new OnMarkerClickListener()
                {

                    @Override
                    public boolean onMarkerClick(Marker arg0) {
                        arg0.getId() //get id
                        //use switch case
                        // or use title
                        if(arg0.getTitle().equals("title"))   
                        // do something
                        return true;
                    }

                });