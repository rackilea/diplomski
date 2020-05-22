public static void sort(List list) {
        if (list.size() > 1) {
            Collections.sort(list, INSTANCE);
        }
    }

protected Integer findOrder(Object obj) {
        // Check for regular Ordered interface
        Integer order = super.findOrder(obj);
        if (order != null) {
            return order;
        }

        // Check for @Order and @Priority on various kinds of elements
        if (obj instanceof Class) {
            return OrderUtils.getOrder((Class) obj);
        }
        else if (obj instanceof Method) {
            Order ann = AnnotationUtils.findAnnotation((Method) obj, Order.class);
            if (ann != null) {
                return ann.value();
            }
        }
        else if (obj instanceof AnnotatedElement) {
            Order ann = AnnotationUtils.getAnnotation((AnnotatedElement) obj, Order.class);
            if (ann != null) {
                return ann.value();
            }
        }
        else if (obj != null) {
            return OrderUtils.getOrder(obj.getClass());
        }

        return null;
    }