if (purchase.getSku().equals(SKU_PREMIUM)) {
            // bought the premium upgrade!
            Log.d(TAG, "Purchase is premium upgrade. Congratulating user.");
            alert("Thank you for upgrading to premium!");
            premiumFeature = true;

            SharedPreferences sharedPref = context.getSharedPreferences(
                  "my_sp", Context.MODE_PRIVATE);
            sharedPref.edit().putBoolean("isPremium, premiumFeature).commit();

            updateUi();
            setWaitScreen(false);
        }