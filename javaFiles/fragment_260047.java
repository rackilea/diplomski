private <T,E> void animalFragments(Class<T> frag, Object obj){
    Method m = null;
    try {
        m = frag.newInstance().getClass().getDeclaredMethod("newInstance", obj.getClass());
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }

    if (m != null) {
        T fragment = null;
        try {
            fragment = (T) m.invoke(null, obj);

            if (fragment != null) {
                FragmentTransaction trans = this.getSupportFragmentManager().beginTransaction();
                trans.add(R.id.ll_fragments_container, (Fragment) fragment, fragment.getClass().getSimpleName());
                trans.commit();
                return true;
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}