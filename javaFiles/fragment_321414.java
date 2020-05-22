if (item.getVersionId().toString().equals(rowItems.get(p).getVersionId().toString()))
                {
                    item.setName(item.getName().toString() + "\n" + rowItems.get(p).getName().toString());
                } else {
                    rowItems.add(item);

                }