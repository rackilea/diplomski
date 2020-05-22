public static SegmentedTimeline newWorkdayTimeline() {
    SegmentedTimeline timeline = new SegmentedTimeline(
        SegmentedTimeline.HOUR_SEGMENT_SIZE, 8, 16);
    timeline.setStartTime(SegmentedTimeline.firstMondayAfter1900()
        + 8 * timeline.getSegmentSize());
    timeline.setBaseTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
    return timeline;
}