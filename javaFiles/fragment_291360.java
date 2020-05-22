public Project123(Project123 s){
    this.head = null;
    for (int i = s.length()-1; i>=0; i--){
        head = new charNode (s.charAt(i), head);
        }
    }