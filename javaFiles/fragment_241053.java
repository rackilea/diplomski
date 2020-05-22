RM obj = new RM();
    Field f = obj.getClass().getDeclaredField("id");
    f.setAccessible(true);
    f.set(obj, 1);

    Assert.assertEquals(1, obj.getId());