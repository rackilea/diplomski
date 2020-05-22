class DetectorWrapper {
      final List<Detector> detectors;

      DetectorWrapper(Class<? extends Detector>... types) {
          ArrayList<Detector> result=new ArrayList<>(types.length);
          try {
              for(Class<? extends Detector> type: types) result.add(type.newInstance());
          }catch(InstantiationException|IllegalAccessException ex) {
              throw new IllegalArgumentException(ex);
          }
          this.detectors=result;
      }
  }