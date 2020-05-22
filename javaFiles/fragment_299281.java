@Value("#{PropertySplitter.toSet('${white.listed.hotel.ids}')}")
private Set<String> fareAlertwhiteListedHotelIds;

...

@Component("PropertySplitter")
public class PropertySplitter {
    public Set<String> toSet(String property) {
        Set<String> set = new HashSet<String>();

        //not sure if you should trim() or not, you decide.
        if(!property.trim().isEmpty()){
            Collections.addAll(set, property.split(","));
        }

        return set;
    }
}