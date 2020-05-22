Predicate<Response> predicate1= e -> StringUtils.isBlank(parameter1) ? true
                : StringUtils.containsIgnoreCase(e.getter(), parameter1);
Predicate<Response> predicate2= e -> StringUtils.isBlank(parameter2) ? true
                    : StringUtils.containsIgnoreCase(e.getter(), parameter2);
Predicate<Response> predicate3= e -> StringUtils.isBlank(parameter3) ? true
                    : StringUtils.containsIgnoreCase(e.getter(), parameter3);
Predicate<Response> predicate4= e -> StringUtils.isBlank(parameter4) ? true
                    : StringUtils.containsIgnoreCase(e.getter(), parameter4);