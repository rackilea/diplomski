public void addToUtilityCardItems() {
        int[] utilitiesLogos = {R.drawable.kenya_power, R.drawable.nairobi_water, R.drawable.startimes, R.drawable.zuku};
        String[] utilitiesNames = {"Kenya Power", "Nairobi Water", "Startimes", "Zuku"};


        for (int i = 0; i < utilitiesNames.length; i++) {
            UtilitiesModel utilities = new UtilitiesModel();
            utilities.setUtilityLogo(utilitiesLogos[i]);
            utilities.setUtilityName(utilitiesNames[i]);
            utilityCardItems.add(utilities);
        }

    }