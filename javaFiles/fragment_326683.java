while (context.nextKey()) {
        Text key = new Text(context.getCurrentKey());
        map.put(key, new HashSet<Text>());
        for(Text v : context.getValues()){
            map.get(key).add(new Text(v));
        }
}