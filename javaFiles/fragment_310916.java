List<CampaignCountry> countryList = new ArrayList<>();
CampaignEntity campaign = new CampaignEntity();

CampaignCountryPK pk1 = new CampaignCountryPK();
pk1.setCountry("Country 1");
CampaignCountry country1 = new CampaignCountry();
country1.setId(pk1);
country1.setCampaignEntity(campaign);

countryList.add(country1);
campaign.setCountries(countryList);