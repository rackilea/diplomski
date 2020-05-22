final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 0x01b21dd213814000L;

      UUID u1 = TimeUUIDUtils.getUniqueTimeUUIDinMillis();
      final long t1 = u1.timestamp();

      long tmp = (t1 - NUM_100NS_INTERVALS_SINCE_UUID_EPOCH) / 10000;

      UUID u2 = TimeUUIDUtils.getTimeUUID(tmp);
      long t2 = u2.timestamp();

      System.out.println(u2.equals(u1));
      System.out.println(t2 == t1);