// ratio - 0.0 - 1.0
List<String> getRatio(Map<Double,String> map, double ratio)
{

    List<String> result = new ArrayList<String>();
    for (Entry<Double, String> e: map.entrySet()) {
        double newRatio = (double) result.size() / map.size();
        if (newRatio >= ratio)
            break;
        result.add(e.getValue());
    }
    return result;
}