HashMap<String, Integer> memberMap = new HashMap<>();
List<Document> members = (List<Document>)doc.get("members");
for (Document member : members) {
    memberMap.put(
            (String)member.get("membername"),
            (Integer)member.get("rank"));
}