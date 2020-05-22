List<Detail> latestDetails = new ArrayList<Detail>();
for (Collection<Detail> detailsPerAppId : detailsByAppId.asMap().values()) {
  Detail latestDetail = Collections.max(detailsPerAppId, new Comparator<Detail>() {
    @Override
    public int compare(Detail d1, Detail d2) {
      return d1.getCreatedOn().compareTo(d2.getCreatedOn());
    }
  });
  latestDetails.add(latestDetail);
}
return latestDetails;