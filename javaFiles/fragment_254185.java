if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network current_network = null;
        for (Network n : cm.getAllNetworks())
        {
            if (cm.getNetworkInfo(n).getTypeName().equals("WIFI")) {
                current_network = n;
                break;
            }
        }

        if (current_network != null)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                cm.bindProcessToNetwork(current_network);
            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ConnectivityManager.setProcessDefaultNetwork(current_network);
            }
        }
    }