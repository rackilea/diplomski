class ConstantDirectionExpander implements PathExpander<STATE>() {
        @Override
        public Iterable<Relationship> expand(Path path, BranchState<STATE> state) {
            if (path.length()==0) {
                return path.endNode().getRelationships(types);
            } else {
                Direction direction = getDirectionOfLastRelationship(path);
                return path.endNode().getRelationships(direction, types);
            }
        }

        @Override
        public PathExpander<STATE> reverse() {
            return this;
        }

        private Direction getDirectionOfLastRelationship(Path path) {
            assert path.length() > 0;
            Direction direction = Direction.INCOMING;
            if (path.endNode().equals(path.lastRelationship().getEndNode())) {
                direction = Direction.OUTGOING;
            }
            return direction;
        }
    }