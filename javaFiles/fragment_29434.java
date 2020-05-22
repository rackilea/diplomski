Observable<String[]> targetIdList = Observable.just(targetList)
            .map((List<KalturaVideo> kalturaVideos) -> {
                if(kalturaVideos == null || kalturaVideos.isEmpty()){
                    return new String[]{""};
                }
                String[] result = new String[kalturaVideos.size()];
                int index = 0;
                for (KalturaVideo item : kalturaVideos) {
                    result[index] = item.getId();
                }
                return result;
            });