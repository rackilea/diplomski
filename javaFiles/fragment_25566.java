return channelCode == null ? null : Iterables.find(Arrays.asList(values()),
    new Predicate<PresentationChannel>() {
        public boolean apply(PresentationChannel input) {
            return input.getChannelCode().equals(channelCode);
        }
    }, null);