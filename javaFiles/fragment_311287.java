List<Child> childList = new ArrayList<Child>();
childList.add(new Child());

List<? extends Parent> parentList = childList;
parentList.set(0, new Parent());

Child child = childList.get(0); // No! It's not a child! Type safety is broken...