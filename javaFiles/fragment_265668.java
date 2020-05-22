private String getGiftFinderQuerySet(final GiftFinderForm giftFinderForm)
    {
        String searchQuery = StringUtils.EMPTY;
        final Set<String> giftFinderQuerySet = new LinkedHashSet<String>();

        final Set<String> ageSet = giftFinderForm.getAgeSet();
        final Set<String> priceSet = giftFinderForm.getPriceSet();
        if (giftFinderForm.getGenderSet() != null && !(giftFinderForm.getGenderSet().isEmpty()))
        {
            final Set<String> genderSet = giftFinderForm.getGenderSet();
            for (final String gender : genderSet)
            {
                final String[] genderList = gender.split(FACET_SEPARATOR);// This will bring first- [sort, bestsellerRating, gender, Female]  at one time, then [bestsellerRating, gender, Male] later in the next loop
                for (int keyIndex = 0; keyIndex < genderList.length - 1; keyIndex++)
                {
                    if (keyIndex != (genderList.length - 1))
                    {
                        keyIndex = keyIndex + keyIndex;
                    }
                    final int valueIndex = keyIndex + 1;

                    giftFinderQuerySet.add(genderList[keyIndex] + FACET_SEPARATOR + genderList[valueIndex]);

                }
            }
        }

        if (giftFinderForm.getAgeSet() != null && !(giftFinderForm.getAgeSet().isEmpty()))
        {
        for (final String age : ageSet)
        {
            final String[] ageList = age.split(FACET_SEPARATOR);
            for (int i = 0; i < ageList.length - 1; i++)
            {
                if (i != (ageList.length - 1))
                {
                    i = i + i;
                }
                final int j = i + 1;
                giftFinderQuerySet.add(ageList[i] + FACET_SEPARATOR + ageList[j]);

            }
        }
        }
        if (giftFinderForm.getPriceSet() != null && !(giftFinderForm.getPriceSet().isEmpty()))
        {
        for (final String price : priceSet)
        {
            final String[] priceList = price.split(FACET_SEPARATOR);
            for (int i = 0; i < priceList.length - 1; i++)
            {
                if (i != (priceList.length - 1))
                {
                    i = i + i;
                }
                final int j = i + 1;
                giftFinderQuerySet.add(priceList[i] + FACET_SEPARATOR + priceList[j]);
            }
        }
        }

        for (final String query : giftFinderQuerySet)
        {
            searchQuery = searchQuery.concat(query + FACET_SEPARATOR);
        }
        searchQuery = searchQuery.substring(0, searchQuery.length() - 1); //Removing the last FACET_SEPARATOR which will be the final query
        return searchQuery;
    }