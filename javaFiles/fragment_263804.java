ordinal = tr.getOrdinal(new CategoryPath(nodeCategory.getPath(), '/')); 
        EnumChildren childrenEnumeration = new EnumChildren(ordinal);
        if (childrenEnumeration.hasChildren()) {
            do {
                int current = childrenEnumeration.nextElement();
                Category child = new Category(tr.getPath(current).toString());
                addChildren(child);
                nodeCategory.children.add(child);
            } while (childrenEnumeration.hasMoreElements());
        }