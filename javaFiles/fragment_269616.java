public class KeywordMerged {
    public static KeywordMerged from(Keyword k) {            
        KeywordMetric metric = new KeywordMetric();
        metric.setPrice(k.getPrice());
        metric.setMetricDay(k.getMetricDay());
        metric.setPosition(k.getPosition());

        KeywordMerged merged = new KeywordMerged();
        merged.setId(k.getId());
        merged.setName(k.getName());
        merged.setOwner(k.getOwner());
        merged.setMetricList(new ArrayList<>(Arrays.asList(metric)));
        return merged;
    }
}