class DetectorWrapper {
    final List<Detector> detectors;

    DetectorWrapper(Supplier<? extends Detector>... types) {
        ArrayList<Detector> result=new ArrayList<>(types.length);
        for(Supplier<? extends Detector> s: types) result.add(s.get());
        this.detectors=result;
    }
}