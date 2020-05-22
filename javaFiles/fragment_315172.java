StringBuilder allowBuilder = new StringBuilder("Allowed ");
StringBuilder notAllowBuilder = new StringBuilder("Not allowed ");

List<String> allowList = new ArrayList<String>();
List<String> notAllowList = new ArrayList<String>();

for (String blistItem : Blist) {
    if (Alist.contains(blistItem)) {
        allowList.add(blistItem);
    } else {
        notAllowList.add(blistItem);
    }
}

for (int i = 0; i < allowList.size(); i++) {
    if (i == 0) {
        allowBuilder.append(allowList.get(i));
    } else {
        if (i + 1 < allowList.size()) {
            allowBuilder.append(", ").append(allowList.get(i));
        } else {
            allowBuilder.append(" and ").append(allowList.get(i));
        }
    }
}

for (int i = 0; i < notAllowList.size(); i++) {
    if (i == 0) {
        notAllowBuilder.append(notAllowList.get(i));
    } else {
        if (i + 1 < notAllowList.size()) {
            notAllowBuilder.append(", ").append(notAllowList.get(i));
        } else {
            notAllowBuilder.append(" and ").append(notAllowList.get(i));
        }
    }
}

System.out.println(notAllowBuilder.toString());
System.out.println(allowBuilder.toString());