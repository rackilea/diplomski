if (user_ids == null || source_region.isEmpty())
    return true;
Object obj = user_ids.get(source_region);
if (obj == null)
    return true;
String source_regions_user_id = obj.toString();
if (source_regions_user_id.isEmpty())
    return true;
// use value here