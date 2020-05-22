gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    setClicked(groupPosition, childPosition);
                    System.out.println("position" + checkedPositions.get(groupPosition));
                    if (checkedPositions.get(groupPosition) != null) {
                        boolean isChecked = checkedPositions.get(groupPosition).get(childPosition);

                        if(!isChecked){
                        }

                    } else {
                        System.out.println("false");
                    }

                }
            });