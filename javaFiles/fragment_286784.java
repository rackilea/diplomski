List<APIBean> apiBeans = IntStream.range(0, apiQueueData.size() / 6)
        .mapToObj(i -> apiQueueData.subList(i * 6, (i + 1) * 6))
        .map(data -> {
            String applId = data.get(0).getParameterValue();
            String transactionType = data.get(1).getParameterValue();
            String phsOrgCode = data.get(2).getParameterValue();
            String roleTypeCode = data.get(3).getParameterValue();
            String personId = data.get(4).getParameterValue();
            String versionId = data.get(5).getParameterValue();
            return new APIBean(applId, transactionType, phsOrgCode, roleTypeCode, personId, versionId);
        })
        .collect(Collectors.toList());