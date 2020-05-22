class MatchContext {
         public int level;
         public Node result;
    }

    public boolean match(Node object, int level, MatchContext ctx) {
        if (no match)
            return false;
        boolean found = false;
        for (all children in object) {
            if (match(child, level + 1, ctx))
                found = true;
        }
        if (!found && level > ctx.level) {
            ctx.level = level;
            ctx.result = this;
        }
        return found;
    }