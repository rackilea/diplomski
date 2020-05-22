public static SegmentedTimeline newWorkdayTimeline() {
    SegmentedTimeline timeline = new SegmentedTimeline(
        SegmentedTimeline.HOUR_SEGMENT_SIZE, 10, 14);
    timeline.setStartTime(SegmentedTimeline.firstMondayAfter1900()
        + 7 * timeline.getSegmentSize());
    timeline.setBaseTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
    return timeline;
}