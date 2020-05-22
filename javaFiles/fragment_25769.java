String sortBy = "name";
    list.sort(Comparator.comparing(report -> {
        try {
            return (Comparable) report.getClass().getDeclaredField(sortBy).get(report);
        } catch (Exception e) {
            throw new RuntimeException("Ooops", e);
        }
    }));