ConnectivityManager connectivity = (ConnectivityManager) MyApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivity != null)
                {
                    for (Network network : connectivity.getAllNetworks())
                    {
                        NetworkInfo networkInfo = connectivity.getNetworkInfo(network);

                        if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
                        {
                            if (networkInfo.isConnected())
                            {
                                Socket sock =  network.getSocketFactory().createSocket();
                            }
                        }
                    }
            }