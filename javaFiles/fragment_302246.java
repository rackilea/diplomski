public ArrayList<SelectItem> propertiesToSelectItemList(final Properties props)
    {
        final ArrayList<SelectItem> result = new ArrayList<SelectItem>();
        for(Map.Entry<Object, Object> me : props.entrySet())
        {
            result.add(new SelectItem((String)me.getKey(), (String)me.getValue()));
        }
        return result;
    }