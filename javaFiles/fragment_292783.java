Section prev = null;
for (String line; (line = bufferedReader.readLine()) != null; ) {
    if (prev == null && line begins with root_depth whitespaces) {
        Section root = new Section(text_of_line, root_depth);
        prev = root;
    }
    else {
        int t_depth = no. of whitespaces at the beginning of this line;
        if (t_depth > prev.getDepth())
            // assuming that empty sections are not allowed
            Section t_section = new Section(text_of_line, t_depth, prev);
            prev.addChild(t_section);
        }
        else if (t_depth == prev.getDepth) {
            Section t_section = new Section(text_of_line, t_depth, prev.getParent());
            prev.getParent().addChild(t_section);
        }
        else {
            while (t_depth < prev.getDepth()) {
                prev = prev.getParent();
            }
            // at this point, (t_depth == prev.getDepth()) = true
            Section t_section = new Section(text_of_line, t_depth, prev.getParent());
            prev.getParent().addChild(t_section);
        }
    }
}