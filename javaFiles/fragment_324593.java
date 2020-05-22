for (List<String> internal : Array_AcidExp) {
        if (internal != null) {
            for (int i = 0; i < internal.size(); i++) {
                if (internal.get(i) == null) {
                    internal.remove(i)
                }
            }
        }
    }