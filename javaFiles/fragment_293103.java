if (c.getInt(2)==1){
    labels.add(new Answer(c.getInt(2), true));
    labels.add(new Answer(c.getInt(3), false));
    tacno.setTag(labels.get(0));
    netacno.setTag(labels.get(1));
} else {
    labels.add(new Answer(c.getInt(2), false));
    labels.add(new Answer(c.getInt(3), true));
    netacno.setTag(labels.get(0));
    tacno.setTag(labels.get(1));
}