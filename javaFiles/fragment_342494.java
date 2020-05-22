public void printBones(Bone bone) {
        if(bone == null) {
            return;
        }

        List<Bone> children = bone.getChildren();
        if(children != null && children.size() > 0) {
            for(Bone bone : children) {
                printBones(bone);  
            }
        }

        System.out.println(bone.getName());
    }