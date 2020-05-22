class DetectorWrapper {
    final List<Detector> detectors;

    DetectorWrapper(Supplier<? extends Detector>... types) {
        detectors=Arrays.stream(types).map(Supplier::get).collect(Collectors.toList());
    }
}