if(Utils.connectivity(getActivity()))
            {
                new RetrieveXML().execute(URL);
                XMLParser parser = new XMLParser();
            }
            else
            {
                Toast.makeText(getActivity(), "Please connect to working internet connection.", Toast.LENGTH_SHORT).show();
            }