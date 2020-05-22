List<String> newMembers = new ArrayList<String>();
for (MyClass entry : contactClassList) {
    if (entry.isChecked) {
        newMembers.add(entry.getUsernameEmail());
    }
}
System.out.println(newMember.size());