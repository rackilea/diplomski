// Assuming SubConf2 and SubConf3 both extend SubConf ...
HashMap<String, SubConf2> map = new HashMap<>();
Map<String, ? extends SubConf> subconfMap = map;
// This doesn't work, because then you could call map.get("key") 
// and get SubConf3 which is not compatible with the declared SubConf2
subconfMap.put("key", new SubConf3());

// The problem cannot happen with with Map<String, SubConf>, because
// the following statement causes compile time error:
Map<String, SubConf> subconfMap = new HashMap<String, SubConf2>();