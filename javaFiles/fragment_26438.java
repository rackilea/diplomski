private Float getSum(List<String> list)
{
    Float sum = 0f;
    if (!list.isEmpty() && list.size() > 1) {
        for (int i = 1; i < list.size(); i++) {
            sum+= Float.parseFloat(list.get(i));
        }
    }
    return sum;
}