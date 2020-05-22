final List<Map<String, Object>> maps = ...;

if (Optional.ofNullable(map.get(1).get("ACC_NUM")).filter(acc_num -> acc_num.equals(map.get(0).get("ACC_NUM"))).isPresent())
{
    map.get(0).putAll(map.get(1));
}