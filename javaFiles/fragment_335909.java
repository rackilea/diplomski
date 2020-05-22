ParseQuery query = new ParseQuery("Child");
        query.fromLocalDatastore();
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    removeAllViews(pager);
                    children.clear(); //Clear it out before we regen every person!
                    for (int i = 0; i < objects.size(); i++) {
                        ChildInfo child = new ChildInfo();
                        child.name = objects.get(i).getString("Name");
                        child.gradeLevel = objects.get(i).getString("GradeLevel");
                        child.gradeLevelInt = objects.get(i).getInt("GradeLevelInt");
                        children.add(child);
                    }
                    Log.i("HomePagerAdapter", "Children Size: " + children.size() + "\n     Obj Size: " + objects.size());
                    for (int i = 0; i < children.size(); i++) {
                        addChild(pager, children.get(i).name, children.get(i).gradeLevelInt);
                    }
                } else {
                    Log.e("HomePagerAdapter", e.toString());
                }
            }
        });