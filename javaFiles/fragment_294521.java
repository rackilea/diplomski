final PkgLine pkgLine = ...;
final Date startDate = ...;
final Date endDate = ...;

Promise<List<WrapSpec>> wrapSpecPromise =
  new Job() {
    @Override
    public List<WrapSpec> doJobWithResult() throws Exception {
      return
        PkgLoad.findDistinctWrapSpecBetweenDates(
          pkgLine,
          startDate,
          endDate
        );               
    }
  }.now();