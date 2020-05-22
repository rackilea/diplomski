List<UserDeactivationThreshold> thresholds = new ArrayList<>();

// fill the list somehow

// then stream for minimum thresholdValue:
UserDeactivationThreshold minThreshold = thresholds..stream()
                .min(Comparator.comparing(UserDeactivationThreshold::getThresholdValue))
                .get()