public static <T> ListProperty<T> listProperty(final Property<ObservableList<T>> property) {
    Objects.requireNonNull(property, "property must not be null");
    ListProperty<T> adapter = new ListPropertyBase<T>() {
        // PENDING JW: need weakListener?
        private InvalidationListener hack15793;
        {
            Bindings.bindBidirectional(this, property);
            hack15793 = o -> {
                ObservableList<T> newItems =property.getValue();
                ObservableList<T> oldItems = get();
                // force rewiring to new list if equals
                boolean changedEquals = (newItems != null) && (oldItems != null) 
                        && newItems.equals(oldItems);
                if (changedEquals) {
                    set(newItems);
                }
            };
            property.addListener(hack15793);
        }

        @Override
        public Object getBean() {
            return null; // virtual property, no bean
        }

        @Override
        public String getName() {
            return property.getName();
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                Bindings.unbindBidirectional(property, this);
                property.removeListener(hack15793);
            } finally {
                super.finalize();
            }
        }

    };
    return adapter;
}