expandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                long packedPosition = expandableListView.getExpandableListPosition(position);
                int groupPosition = ExpandableListView.getPackedPositionGroup(packedPosition);

                if (adapter.getAllData().size() != 0 && adapter.getAllData() != null) {
                    adapter.getAllData().remove(groupPosition);
                    adapter.notifyDataSetChanged();
                    adapter.notifyDataSetChanged();

                }
                return false;
            }
        });