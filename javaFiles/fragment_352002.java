public String[] list(FilenameFilter filter) {
            String names[] = list();
            if ((names == null) || (filter == null)) {
                return names;
            }
            List<String> v = new ArrayList<>();
            for (int i = 0 ; i < names.length ; i++) {
                if (filter.accept(this, names[i])) {
                    v.add(names[i]);
                }
            }
            return v.toArray(new String[v.size()]);
        }