public class Whatever {
    private WhateverHolder<?> holder;

    public void bazToList() {
        holder.bazToList();
    }

    public void listToBaz() {
        holder.listToBaz();
    }

    private static class WhateverHolder<T> {
        private List<T> list;
        private Foo<T> baz;

        public void bazToList() {
            list.add(baz.bar());
        }

        public void listToBaz() {
            baz.foo(list.get(1));
        }
    }
}