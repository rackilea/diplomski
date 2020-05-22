@Override
    public void invalidated(Observable observable) {
        final BooleanOrBinding binding = ref.get();
        if (binding == null) {
            observable.removeListener(this);
        } else {
            // short circuit invalidation. This BooleanBinding becomes
            // only invalid if the first operator changes or the
            // first parameter is false.
            if ((binding.op1.equals(observable) || (binding.isValid() && !binding.op1.get()))) {
                binding.invalidate();
            }
        }
    }