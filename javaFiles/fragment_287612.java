Collection<?> altNames = certificate.getSubjectAlternativeNames();
        for (Object i : altNames) {
            List<Object> item = (java.util.List) i;
            Integer type = (Integer) item.get(0);
            try {
                if (type > 0) {
                    continue;
                }
                String[] arr = StringEscapeUtils.escapeHtml(new String((byte[]) item.get(1))).split(";");
                return Arrays.asList(arr)
                        .stream()
                        .map(k -> k.trim())
                        .filter(u -> isCNPJ(u))
                        .findFirst().get();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return null;