public List<Class> getAllSuperclasses(Class cls) {
        List<Class> res = new ArrayList<>();
        while ((cls = cls.getSuperclass()) != null) {
            res.add(cls);
        }
        return res;
    }