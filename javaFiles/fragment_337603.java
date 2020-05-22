public Set<ClassCTreeDto> unique() {

            long parent = 0;
            long div_id = 10;

            List<ClassCTreeDto> treestructure = new ArrayList<ClassCTreeDto>();
            List<ClassCTreeDto> treestructure2 = new ArrayList<ClassCTreeDto>();
            Set<ClassCTreeDto> all = new HashSet<ClassCTreeDto>();

            List<ClassC> list = getAll();

            for (ClassC ClassC: list) {
                ClassCTreeDto tree = new ClassCTreeDto();

                tree.setParent(parent);
                tree.setId(ClassC.getFkId().getId());
                tree.setName(ClassC.getFkId().getIdName());

                if (containsLocation(treestructure, tree.getIdName())) {
                    treestructure.remove(tree);

                }

                else {
                    treestructure.add(tree);
                }

            }
            for (ClassC classC : list) {

                ClassCTreeDto tree2 = new ClassCTreeDto ();

                tree2.setParent(classC.getFkId().getId());
                tree2.setId(div_id);
                tree2.setName(classC.getFkDId().getDName());

                treestructure2.add(tree2);

            }

            all.addAll(treestructure);
            all.addAll(treestructure2);

            return all;
        }