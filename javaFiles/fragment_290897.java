class DetectorWrapper<T extends Detector> {
    final List<T> detectors;

    DetectorWrapper(Class<? extends T>... types) {
        ArrayList<T> result=new ArrayList<>(types.length);
        try {
            for(Class<? extends T> type: types) result.add(type.newInstance());
        }catch(InstantiationException|IllegalAccessException ex) {
            throw new IllegalArgumentException(ex);
        }
        this.detectors=result;
    }
}