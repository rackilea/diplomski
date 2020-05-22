switch (menuItem.getItemId()) {

            case R.id.nav_home: {
                if (checkInternetConnection(getApplicationContext())) {
                    Log.i(LOG_TAG, "PROVJERA NETA  POVEZAN");
                    start_loader();
                } else {
                    mEmptyStateTextView.setText("Cannot connect to network, please check your network status and try again.");
                    // Clear the adapter of previous earthquake data

                }
                break;
            }
            case R.id.nav_history: {
                pozoviHistory(null);
                break;
            }
            case R.id.nav_favourite: {
                pozoviFavorites();
                break;
            }

        }