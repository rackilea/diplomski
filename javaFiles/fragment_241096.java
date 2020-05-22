if (user_ids == null)
    return true;
if (! "".equals(source_region)) // I think you meant the opposite check
    return true;
if (! user_ids.containsKey(source_region)) // Redundant, the next check will cover this
    return true;
if (user_ids.get(source_region) == null)
    return true;
if (user_ids.get(source_region) == "") // Object is not a string, so this will always fail
    return true;
String source_regions_user_id = user_ids.get(source_region).toString();