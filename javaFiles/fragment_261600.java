public void writeActivity(Activity activity) {
    writer.writeStartElement("activity");
    writer.writeAttribute("name", activity.getName());

    writer.writeStartElement("children");
    for(Activity child : activity.getChildren()) {
        writeActivity(child);
    }
    writer.writeEndElement(); //ends element children

    writer.writeEndElement(); //ends element activity
}