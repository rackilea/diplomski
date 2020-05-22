interface ISpace<S extends ISpace<S, A>, A extends IAtom<S, A>> {
        List<? extends IAtom<S, A>> getList(); //// CHANGED
}

interface IAtom<S extends ISpace<S, A>, A extends IAtom<S, A>> {
        S getSpace();
}

abstract class Space<S extends Space<S, A>, A extends Atom<S, A>>
                implements ISpace<S, A> {

        private final List<Atom<S, A>> atoms = new LinkedList<Atom<S, A>>(); ////CHANGED

        public Space() {
        }
        public Space<S, A> getSpace() {
                return this;
        }
        @Override
        public List<Atom<S, A>> getList() {  //// CHANGED
                return atoms;
        }
}

abstract class Atom<S extends Space<S, A>, A extends Atom<S, A>>
                implements IAtom<S, A> {

        private final S space;

        public Atom(S someSpace) {
                this.space = someSpace;
                space.getList().add(this);
        }

        @Override
        public S getSpace() {
                return space;
        }

        public Atom<S, A> getAtom() {
                return this;
        }
}

class Space1 extends Space<Space1, Atom1> {
        public Space1() {
        }
}

class Atom1 extends Atom<Space1, Atom1> {
        public Atom1(Space1 someSpace) {
                super(someSpace);
        }
}