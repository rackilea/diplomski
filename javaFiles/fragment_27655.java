public static class EventTimeLine<T> {

    private Map<Double, KeyFrame<T>> mapEvents;

    public EventTimeLine() {
        mapEvents = new TreeMap<>();
    }

    public void add(double progress, T value) {
        mapEvents.put(progress, new KeyFrame<T>(progress, value));
    }

    public List<T> getValues() {
        return Collections.unmodifiableList(mapEvents.values().stream()
                .map(kf -> kf.getValue())
                .collect(Collectors.toList()));
    }

    public double getPointOnTimeLineFor(T value) {
        for (Map.Entry<Double, KeyFrame<T>> entry : mapEvents.entrySet()) {
            if (entry.getValue().getValue() == value) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public List<T> getValuesAt(double progress) {

        if (progress < 0) {
            progress = 0;
        } else if (progress > 1) {
            progress = 1;
        }

        return getKeyFramesBetween(progress, 0.01f)
                .stream()
                .map(kf -> kf.getValue())
                .collect(Collectors.toList());
    }

    public List<KeyFrame<T>> getKeyFramesBetween(double progress, double delta) {

        int startAt = 0;

        List<Double> keyFrames = new ArrayList<>(mapEvents.keySet());
        while (startAt < keyFrames.size() && keyFrames.get(startAt) <= progress - delta) {
            startAt++;
        }

        startAt = Math.min(keyFrames.size() - 1, startAt);
        int endAt = startAt;
        while (endAt < keyFrames.size() && keyFrames.get(endAt) <= progress + delta) {
            endAt++;
        }
        endAt = Math.min(keyFrames.size() - 1, endAt);

        List<KeyFrame<T>> frames = new ArrayList<>(5);
        for (int index = startAt; index <= endAt; index++) {
            KeyFrame<T> keyFrame = mapEvents.get(keyFrames.get(index));
            if (keyFrame.getProgress() >= progress - delta
                    && keyFrame.getProgress() <= progress + delta) {
                frames.add(keyFrame);
            }
        }

        return frames;

    }

    public class KeyFrame<T> {

        private double progress;
        private T value;

        public KeyFrame(double progress, T value) {
            this.progress = progress;
            this.value = value;
        }

        public double getProgress() {
            return progress;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "KeyFrame progress = " + getProgress() + "; value = " + getValue();
        }

    }

}