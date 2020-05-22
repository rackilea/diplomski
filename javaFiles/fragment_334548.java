ConcurrentMap<Integer, Device> map =
        devicesList.stream()
                .collect(Collectors.toMap(item -> item.id,
                                          item -> item,
                                          (item1,item2)->item2,
                                          ConcurrentHashMap::new));